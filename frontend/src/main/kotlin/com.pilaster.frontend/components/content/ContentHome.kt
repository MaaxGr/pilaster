package com.pilaster.frontend.components.content

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div

class ContentHome : RComponent<RProps, RState>() {
    override fun RBuilder.render() {

        div {
            setProp("data-role","cube")
        }


    }


}