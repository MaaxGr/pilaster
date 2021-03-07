package com.pilaster.frontend.components.window

import com.pilaster.frontend.store
import react.*

external interface WindowHandlerProps : RProps {

}

external interface WindowHandlerState : RState {
    var windows : MutableMap<String,WindowConfig>
}


class WindowHandler : RComponent<WindowHandlerProps, WindowHandlerState>() {

    override fun RBuilder.render() {
        state.windows = mutableMapOf("f1" to WindowConfig("Hallo123"))
        store.subscribe{
            setState{

            }

        }

        state.windows.filter {it.value.new}.forEach {
            child(Window::class){
                attrs.config = it.value
            }
            it.value.new = false
        }

    }

    fun newWindow(){
        state.windows["F4"] = WindowConfig("Noch ein Fenster")
    }

}