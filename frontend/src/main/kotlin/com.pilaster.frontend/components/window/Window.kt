package com.pilaster.frontend.components.window

import com.pilaster.frontend.components.state.AppState
import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.js.onWheelFunction
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div

external interface WindowProps : RProps{
    var config : WindowConfig
}

class Window :RComponent<WindowProps,RState>() {

    var onClose : (Event) -> Unit
        get()  = throw UnsupportedOperationException("You can't read variable onWheel")
        set(newValue) {
        //    consumer.onTagEvent(this, "onwheel", newValue)
        }

    override fun RBuilder.render() {
        div {
            //setProp("class","window")
            setProp("data-role", "window")
            +props.config.title

            attrs {
                //onWheelFunction
                //onCl
            }

        }
    }
}