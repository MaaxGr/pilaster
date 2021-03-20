package com.pilaster.frontend.handler

import kotlinx.browser.sessionStorage

class SessionHandler {

    fun storeAccesstoken (accessToken:String){
        sessionStorage.setItem("accessToken",accessToken)
    }

    fun getAccesstoken():String{
        return sessionStorage.getItem("accessToken")?: ""
    }

    fun clearSession(){
        sessionStorage.clear()
    }
}