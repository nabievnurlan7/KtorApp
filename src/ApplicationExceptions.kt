package com.nurlandroid

import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond

sealed class ApplicationExceptions(message: String) : RuntimeException(message) {
    class InvalidCredentialsException(message: String = "Invalid credentials") : ApplicationExceptions(message)
}

suspend fun ApplicationCall.processError(exception: ApplicationExceptions) {
    val errorMap = mapOf("OK" to false, "error" to (exception.message ?: ""))

    when (exception) {
        is ApplicationExceptions.InvalidCredentialsException -> respond(HttpStatusCode.Unauthorized, errorMap)
        else -> respond(HttpStatusCode.Forbidden)
    }
}