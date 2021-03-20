package com.pilaster.frontend.components.ribbonmenu


import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.button
import react.dom.span


external interface RibbonButtonProps : RProps {
    var buttonConfig: RibbonButtonConfig
}

class RibbonButton : RComponent<RibbonButtonProps, RState>() {
    override fun RBuilder.render() {

        button {
            setProp("class","ribbon-button")
            span {
                setProp("class","mif-star-full")
            }
            span {
                setProp("class","caption")
                +props.buttonConfig.buttonSays
            }
            attrs {
                onClickFunction = {
                    props.buttonConfig.onClickAction.invoke()
                }
            }
        }
    }
}