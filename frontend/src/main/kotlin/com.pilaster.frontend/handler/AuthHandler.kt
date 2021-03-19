package com.pilaster.frontend.handler

import com.pilaster.common.CommBody
import com.pilaster.common.CommHead
import com.pilaster.common.login.SaltRequest

object AuthHandler {

    public fun performLogin(username:String,secret:String){
        getSalt(username)
    }

    private fun getSalt(username:String) : String{
        ConnHandler.sendRequest(
            CommHead(
                "SALT",
                "",
                "SALT",
                SaltRequest(
                    username
                )
            )
        )
        return ""
    }
}