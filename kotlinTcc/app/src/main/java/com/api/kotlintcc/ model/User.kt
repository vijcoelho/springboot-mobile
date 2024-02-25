package com.api.kotlintcc.model

class User {

    private var id: Int = 0
    private var name: String = ""
    private var email: String = ""
    private var password: String = ""
    private var address: String = ""

    public fun getId(): Int {
        return id
    }

    public fun setId(id: Int) {
        this.id = id
    }

    public fun getName(): String{
        return name
    }

    public fun setName(name: String) {
        this.name = name
    }

    public fun getEmail(): String {
        return email
    }

    public fun setEmail(email: String) {
        this.email = email
    }

    public fun getPassword(): String {
        return password
    }

    public fun setPassword(password: String) {
        this.password = password
    }

    public fun getAddress(): String {
        return address
    }

    public fun setAddress(address: String) {
        this.address = address
    }
}