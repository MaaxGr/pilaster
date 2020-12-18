package com.pilaster.frontend.components.charms

import com.pilaster.frontend.components.CharmsEnum
import com.pilaster.frontend.components.state.CharmsState
import com.pilaster.frontend.store
import kotlinext.js.getOwnPropertyNames
import kotlinx.browser.document
import kotlinx.html.js.onClickFunction
import react.*
import react.dom.*


external interface CharmsHandlerState : RState {
    var charms: CharmsState
}

external interface CharmsHandlerProps : RProps {

}

class CharmsHandler : RComponent<CharmsHandlerProps, CharmsHandlerState>() {


    override fun RBuilder.render() {
        store.subscribe {
            setState {
                charms = store.state.charms[CharmsEnum.TASKBAR]!!
            }
        }

        div {
            setProp("data-role", "charms")
            setProp("id", "window-bar")
            setProp("data-opacity", ".75")
            setProp("data-position", "right")
            setProp("class", "charms right-side " + state?.charms?._open)




            div {

                setProp("class", "container")
                +"Offene Fenster:"
                button {
                    +"Knopf 1"
                }
                button {
                    +"Knopf 2"
                }
                button {
                    +"Knopf 3"
                }
            }
            button {
                +"Schließen"
                attrs {
                    onClickFunction = {
                        store.state.charms[CharmsEnum.TASKBAR]?.toggleOpen()
                        store.dispatch("Fu")
                    }
                }
            }
        }


    }

}