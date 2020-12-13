package com.pilaster.frontend

import com.pilaster.frontend.components.App
import kotlinx.browser.document
import org.reduxkotlin.createStore
import react.dom.render

fun main() {
    render(document.getElementById("root")) {
        child(App::class) {}
    }
}