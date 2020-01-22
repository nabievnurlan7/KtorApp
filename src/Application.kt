package com.nurlandroid


import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.auth.Authentication
import io.ktor.auth.UserIdPrincipal
import io.ktor.auth.authenticate
import io.ktor.auth.jwt.jwt
import io.ktor.features.ContentNegotiation
import io.ktor.features.StatusPages
import io.ktor.http.ContentType
import io.ktor.jackson.jackson
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route
import io.ktor.routing.routing
import org.jetbrains.exposed.sql.Database
import java.util.*


data class Data(val text: String)

data class PostData(val data: Text) {
    data class Text(val text: String)
}

private val dataList: MutableList<Data> = Collections.synchronizedList(
    mutableListOf(
        Data("my data"),
        Data("your data")
    )
)

open class KtorJWT(val secret: String) {
    private val algorithm = Algorithm.HMAC256(secret)
    val verifier = JWT.require(algorithm).build()
    fun sign(name: String): String = JWT.create().withClaim("name", name).sign(algorithm)
}

private val loginInteractor = LoginInteractor()


////////////////////////////////////////////////////////////////

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    val simpleJwt = KtorJWT("secret-for-jwt")

    install(Authentication) {
        jwt {
            verifier(simpleJwt.verifier)
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
                call.respond(mapOf("token" to simpleJwt.sign(post.user)))
            } else {
                throw ApplicationExceptions.InvalidCredentialsException()
            }
        }

        route("/data") {
            get {
                call.respond(mapOf("data" to synchronized(dataList) { dataList.toList() }))
            }

            authenticate {
                post {
                    val post = call.receive<PostData>()
                    dataList += Data(post.data.text)
                    call.respond(mapOf("OK" to true))
                }
            }
        }
    }
}

private fun initDB() {
    Database.connect(DB_URL, DB_DRIVER)
}