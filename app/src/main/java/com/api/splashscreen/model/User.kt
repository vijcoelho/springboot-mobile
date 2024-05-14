package com.api.splashscreen.model

class User {

    private var id: Int? = null
    private var name: String = ""
    private var email: String = ""
    private var password: String = ""

    fun getId(): Int? {
        return this.id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getName(): String {
        return this.name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getEmail(): String {
        return this.email
    }

    fun setEmail(email: String) {
        this.email = email
    }

    fun getPassword(): String {
        return this.password
    }

    fun setPassword(password: String) {
        this.password = password
    }
}