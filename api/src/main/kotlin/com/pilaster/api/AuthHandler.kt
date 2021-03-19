package com.pilaster.api

import com.pilaster.common.login.LoginResponse

object AuthHandler {

    fun createSalt(username:String): String{

        return "ABCDEF"
    }

    fun authUser(username: String, password: String):LoginResponse{
        return if (username == "ASDF" && password == "2ab21bd9c3ce18abe0837f6807a2934d73b45f98f85599f12d192e9ed0adaa95"){ //Dummy-Passwort
            LoginResponse(true, "#TOKEN#")
        } else {
            LoginResponse(false,"")
        }

    }
}