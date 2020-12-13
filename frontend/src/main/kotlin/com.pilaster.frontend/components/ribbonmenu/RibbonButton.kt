package com.pilaster.frontend.components.ribbonmenu

import com.pilaster.frontend.TestMessage
import com.pilaster.frontend.components.AppState
import com.pilaster.frontend.store
import kotlinx.browser.window
import kotlinx.html.js.onClickFunction
import kotlinx.html.js.onDoubleClickFunction
import react.RBuilder
import react.RComponent
import react.RProps
import react.dom.button
import react.dom.span
import react.useEffect

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
                    store.dispatch(props.buttonSays)
                    window.alert("Aktion ausgeführt!")
                }
            }
        }
    }
}