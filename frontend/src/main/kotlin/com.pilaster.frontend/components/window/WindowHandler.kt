package com.pilaster.frontend.components.window

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import react.dom.span

external interface WindowHandlerProps : RProps {



}

external interface WindowHandlerState : RState {

}

class WindowHandler : RComponent<WindowHandlerProps, WindowHandlerState>() {

    val windows : MutableMap<String,WindowConfig> = mutableMapOf(
        "F1" to WindowConfig("Fenster 1"),
        "F2" to WindowConfig("Fenster 2")
    )

    override fun RBuilder.render() {

        windows.forEach {
            child(Window::class){
                attrs.config = it.value
            }
        }


    }

}