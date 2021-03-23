package com.pilaster.frontend.site.component.ribbon

import com.pilaster.frontend.App
import com.pilaster.frontend.components.ribbonmenu.RibbonButtonConfig
import com.pilaster.frontend.components.state.ribbon.RibbonState
import react.*
import react.dom.div
import react.dom.nav
import react.dom.ul

external interface RibbonHeadState : RState{
    var ribbon: RibbonState
}

class RibbonHead : RComponent<RProps,RibbonHeadState>() {
    override fun RBuilder.render() {
        state.ribbon = App.appstate.store.state.ribbon
        App.appstate.store.subscribe{
            setState{
                ribbon = App.appstate.store.state.ribbon
            }
        }

        nav {
            setProp("data-role", "ribbonmenu")
            ul {
                setProp("class", "tabs-holder")

                state.ribbon.tabs.forEach {
                    child(RibbonTab::class) {
                        attrs.title = it.title
                        attrs.isStatic = it.isStatic
                        attrs.targetSection = it.targetSection
                        attrs.onClickAction = it.onClickAction
                    }
                }

            }

            // Content
            div(classes = "content-holder") {
                state.ribbon.elements.distinctBy { it.targetSection }.forEach { elem ->
                    child(RibbonSection::class) {
                        attrs.section = elem.targetSection
                        val buttons = mutableListOf<RibbonButtonConfig>()
                        state.ribbon.elements.filter { it.targetSection == elem.targetSection }.forEach {
                            buttons.add(RibbonButtonConfig(it.buttonText, it.tileGroup))
                        }
                        attrs.buttons = buttons
                    }
                }
            }
        }
    }
}