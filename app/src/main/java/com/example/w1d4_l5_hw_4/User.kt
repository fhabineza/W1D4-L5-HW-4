package com.example.w1d4_l5_hw_4

import java.io.Serializable

class User : Serializable{
    var firstname: String
        get() = field
        set(value) {
            field = value
        }

    var lastname : String
    get() = field
    set(value)  {
        field = value
    }

    var username : String
    get() = field
    set(value){
        field = value
    }

    var password : String
    get() = field
    set(value){
        field = value
    }


    constructor(firstname: String, lastname: String, username: String, password: String) {
        this.firstname = firstname
        this.lastname = lastname
        this.username = username
        this.password = password
    }
}