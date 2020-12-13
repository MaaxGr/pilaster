package com.pilaster.frontend

import com.pilaster.frontend.components.App
import com.pilaster.frontend.components.content.ContentHandler
import com.pilaster.frontend.components.ribbonmenu.RibbonMenuHandler
import kotlinx.browser.document

import react.dom.render

fun main() {
    render(document.getElementById("root")) {
        child(App::class) {}
    }

    render(document.getElementById("ribbonBarArea")) {
        child(RibbonMenuHandler::class) {
        }
    }

    render(document.getElementById("contentArea")) {
        child(ContentHandler::class) {
        }
    }


}