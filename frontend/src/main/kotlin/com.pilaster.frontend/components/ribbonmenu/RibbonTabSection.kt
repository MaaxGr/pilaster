package com.pilaster.frontend.components.ribbonmenu

import com.pilaster.frontend.components.AppState
import react.RBuilder
import react.RComponent
import react.RProps
import react.dom.div
import react.dom.p

external interface RibbonTabSectionProps : RProps {
    var section: String
    var buttons: List<RibbonButtonConfig>
}


class RibbonTabSection : RComponent<RibbonTabSectionProps, AppState>() {
    override fun RBuilder.render() {
        div {
            setProp("class", "section")
            setProp("id", props.section)

            p {


                if (!props.buttons.isNullOrEmpty()) {
                    props.buttons.forEach {
                        child(RibbonButton::class) {
                            attrs.buttonSays = it.buttonSays
                        }
                    }
                }
            }

        }

    }

}