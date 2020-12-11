package com.pilaster.frontend.components.ribbonmenu

import com.pilaster.frontend.components.AppState
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
            }
        }
    }
}