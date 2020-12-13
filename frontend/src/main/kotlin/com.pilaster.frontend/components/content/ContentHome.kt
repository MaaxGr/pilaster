package com.pilaster.frontend.components.content

import com.pilaster.frontend.components.AppState
import react.RBuilder
import react.RComponent
import react.RProps
import react.dom.div
import react.dom.h1

class ContentHome : RComponent<RProps,AppState>() {
    override fun RBuilder.render() {

        div {
            setProp("data-role","cube")
        }


    }


}