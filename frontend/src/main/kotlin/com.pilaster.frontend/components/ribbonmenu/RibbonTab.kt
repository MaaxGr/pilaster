package com.pilaster.frontend.components.ribbonmenu

import com.pilaster.frontend.components.AppState
import com.pilaster.frontend.store
import kotlinx.browser.window
import kotlinx.html.js.onClickFunction
import kotlinx.html.js.onDoubleClickFunction
import kotlinx.html.onDoubleClick
import react.RBuilder
import react.RComponent
import react.RProps
import react.dom.a
import react.dom.li

external interface RibbonTabProps : RProps {
    var title: String
    var isStatic: Boolean
    var targetSection: String

    var disabled : Boolean
}

class RibbonTab : RComponent<RibbonTabProps, AppState>() {
    override fun RBuilder.render() {
        li {
            if (props.isStatic) {
                setProp("class", "static")
            }
            a {
                setProp("href", "#" + props.targetSection)
                if(props.disabled){
                    setProp("class","disabled")
                }
                +props.title
                attrs {
                    onDoubleClickFunction= {
                        window.alert("Doppelklick")
                    }
                }

                if(props.title == "Home"){
                    store.dispatch("Home")

                    attrs{
                        onClickFunction={
                            store.dispatch("Home")
                        }
                    }
                }

            }
        }
    }
}