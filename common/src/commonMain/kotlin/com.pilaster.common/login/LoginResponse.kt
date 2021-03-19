package com.pilaster.common.login

data class LoginResponse (
        val succeeded : Boolean,
        val accessToken: String
        )