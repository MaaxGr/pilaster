package com.pilaster.api.postament.utils

import com.google.gson.Gson
import kotlin.reflect.KClass

infix fun <T: Any> Any.magrAs(clazz: KClass<T>): T {
    val gson = Gson()
    return gson.fromJson(gson.toJson(this), clazz.java)
}