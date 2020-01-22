package com.nurlandroid

import java.util.*

class LoginInteractor {

    class User(val name: String, val password: String)

    val users: MutableMap<String, User> = Collections.synchronizedMap(
        listOf(User("test", "test"))
            .associateBy { it.name }
            .toMutableMap()
    )

    class LoginRegister(val user: String, val password: String)

    fun checkCredentials(post: LoginRegister): Boolean {
        val user = users.getOrPut(post.user) { User(post.user, post.password) }
        return user.password == post.password
    }
}