package com.nurlandroid


import com.fasterxml.jackson.databind.SerializationFeature
import com.nurlandroid.temp.AnswersInteractor
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.auth.Authentication
import io.ktor.auth.UserIdPrincipal
import io.ktor.auth.authenticate
import io.ktor.auth.jwt.jwt
import io.ktor.features.CORS
import io.ktor.features.ContentNegotiation
import io.ktor.features.StatusPages
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.jackson.jackson
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.response.respondRedirect
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route
import io.ktor.routing.routing
import org.jetbrains.exposed.sql.Database


private val loginInteractor = LoginInteractor()
private val dataInteractor = DummyDataInteractor()

private val answersInteractor = AnswersInteractor()


fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    val tokenizer = LoginInteractor.KtorJWT(SECRET_JWT)

    install(Authentication) {
        jwt {
            verifier(tokenizer.verifier)
            validate {
                UserIdPrincipal(it.payload.getClaim("name").asString())
            }
        }
    }

    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }

    install(CORS) {
        method(HttpMethod.Options)
        method(HttpMethod.Get)
        method(HttpMethod.Post)
        method(HttpMethod.Put)
        method(HttpMethod.Delete)
        method(HttpMethod.Patch)
        header(HttpHeaders.Authorization)
        allowCredentials = true
        anyHost()
    }

    install(StatusPages) {
        exception<ApplicationExceptions> { call.processError(it) }
    }

    routing {
        get("/") {
            call.respondText(APP_NAME, contentType = ContentType.Text.Plain)
        }

        post("/login") {
            val post = call.receive<LoginInteractor.LoginRegister>()

            if (loginInteractor.checkCredentials(post)) {
                call.respond(mapOf("token" to tokenizer.sign(post.user)))
                call.respondRedirect("/", permanent = false)
            } else {
                throw ApplicationExceptions.InvalidCredentialsException()
            }
        }

        post("/sendAnswers") {
            val jsonAnswers = call.receive<String>()

            call.respondText(answersInteractor.processAnswers(jsonAnswers))
        }

        route("/data") {
            get {
                call.respond(mapOf("data" to synchronized(dataInteractor.getDataList()) {
                    dataInteractor.getDataList().toList()
                }))
            }

            authenticate {
                post {
                    val post = call.receive<DummyDataInteractor.PostData>()
                    dataInteractor.putData(post.data.text)
                    call.respond(mapOf("OK" to true))
                }
            }
        }
    }
}

private fun initDB() {
    Database.connect(DB_URL, DB_DRIVER)
}