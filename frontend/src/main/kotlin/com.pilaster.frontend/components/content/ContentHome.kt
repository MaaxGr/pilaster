package com.pilaster.frontend.components.content

import com.pilaster.frontend.AppState
import react.RBuilder
import react.RComponent
import react.RProps
import react.dom.div

class ContentHome : RComponent<RProps, AppState>() {
    override fun RBuilder.render() {

        div {
            setProp("data-role","cube")
        }


    }


}