package com.pilaster.frontend.handler

import com.pilaster.common.CommBody
import com.pilaster.common.CommHead
import com.pilaster.common.login.LoginRequest
import com.pilaster.common.login.LoginResponse
import com.pilaster.common.login.SaltRequest
import com.pilaster.common.login.SaltResponse
import kotlinx.coroutines.*
import kotlinx.css.command
import kotlin.coroutines.CoroutineContext
import kotlin.js.Promise

object AuthHandler : CoroutineScope {

    private var job: Job = Job()

    override val coroutineContext: CoroutineContext
        get() = AuthHandler.job


    fun performLogin(username:String,secret:String){
        launch {
            val salt = getSalt(username)

            println("Salz erhalten: $salt")

            val salted = (hashPassword(username,salt) as Promise<*>).await()
            println("Salted: $salted")

            val accessToken = getAccessToken(username, salted.toString())
            println("AccessToken: ${accessToken.accessToken}")

        }
    }

    private suspend fun getSalt(username:String) : String{
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

        var result : CommHead? = null

        while (result == null){
            result = ConnHandler.antworten.lastOrNull{ commHead: CommHead -> commHead.type == "SALT" }
            delay(100)
        }

        return (JSON.parse<SaltResponse>(JSON.stringify(result.commBody))).salt
    }

    private suspend fun hashPassword(secret: String, salt: String):String {
        return js("digestMessage(salt + secret)")
    }

    private suspend fun getAccessToken(username:String, password:String): LoginResponse{
        ConnHandler.sendRequest(
            CommHead(
                "LOGIN",
                "",
                "LOGIN",
                LoginRequest(
                    username,
                    password
                )
            )
        )

        var result : CommHead? = null

        while (result == null){
            result = ConnHandler.antworten.lastOrNull{ commHead: CommHead -> commHead.type == "LOGIN" }
            delay(100)
        }

        return JSON.parse(JSON.stringify(result.commBody))
    }
}