package com.pilaster.frontend.components.content

import com.pilaster.frontend.components.AppState
import react.RBuilder
import react.RComponent
import react.RProps
import react.dom.h1

class ContentProject : RComponent<RProps, AppState>() {
    override fun RBuilder.render() {
        h1{
            +"Hier sind die Projekte"
        }
    }
}