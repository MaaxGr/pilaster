package com.pilaster.frontend.components.ribbonmenu

import com.pilaster.frontend.components.AppState
import kotlinx.browser.window
import kotlinx.html.js.onClickFunction
import com.pilaster.frontend.store
import react.RBuilder
import react.RComponent
import react.RProps
import react.dom.button
import react.dom.span


external interface RibbonButtonProps : RProps {
    var buttonSays: String
}

class RibbonButton : RComponent<RibbonButtonProps,AppState>() {
    override fun RBuilder.render() {

        button {
            setProp("class","ribbon-button")
            span {
                setProp("class","mif-star-full")
            }
            span {
                setProp("class","caption")
                +props.buttonSays
            }
            attrs {
                onClickFunction = {
                    //store.dispatch(props.buttonSays)
                    store.dispatch("Ticket")
                    //window.alert("Aktion ausgeführt!")
                }
            }
        }
    }
}