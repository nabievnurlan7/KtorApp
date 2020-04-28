package com.nurlandroid

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import java.util.*

class LoginInteractor {

    open class KtorJWT(private val secret: String) {
        private val algorithm = Algorithm.HMAC256(secret)
        val verifier: JWTVerifier = JWT.require(algorithm).build()

        fun sign(name: String): String = JWT.create().withClaim("name", name).sign(algorithm)
    }

    class LoginRegister(val user: String, val password: String)
    class User(val name: String, val password: String)

    private val users: MutableMap<String, User> = Collections.synchronizedMap(
        listOf(User("test", "test"))
            .associateBy { it.name }
            .toMutableMap()
    )

    fun checkCredentials(post: LoginRegister): Boolean {
        val user = users.getOrPut(post.user) {
            User(
                post.user,
                post.password
            )
        }
        return user.password == post.password
    }
}