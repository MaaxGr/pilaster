package com.pilaster.frontend.components.ribbonmenu

import com.pilaster.frontend.components.TabProps
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.*

external interface TopMenuProps : RProps {
    //Children
    var tabSection: MutableList<RibbonTabSection>
}

class TopMenuHandler : RComponent<TabProps, RState>() {

    override fun RBuilder.render() {
        nav {
            setProp("data-role", "ribbonmenu")
            ul {
                setProp("class", "tabs-holder")

                child(RibbonTab::class) {
                    attrs.title = "Home"
                    attrs.isStatic = true
                    attrs.targetSection = "_home_"
                }

                child(RibbonTab::class) {
                    attrs.title = "Projekte"
                    attrs.isStatic = false
                    attrs.targetSection = "_section_projects_"
                }

                child(RibbonTab::class) {
                    attrs.title = "Tickets"
                    attrs.isStatic = false
                    attrs.targetSection = "_section_tickets_"
                }
            }


            // Content Section
            div {
                setProp("class", "content-holder")

                child(RibbonTabSection::class) {
                    attrs.section = "_section_projects_"
                    //attrs.buttons = listOf(RibbonButtonConfig("A"))
                }

                child(RibbonTabSection::class) {
                    attrs.section = "_section_tickets_"
                    attrs.buttons = listOf(
                            RibbonButtonConfig("Alle Tickets", "Öffnen"),
                            RibbonButtonConfig("Neue Tickets", "Öffnen"),
                            RibbonButtonConfig("Mir Zugewiesen", "Öffnen"),
                            RibbonButtonConfig("Neu (blanko)", "Öffnen"),
                            RibbonButtonConfig("Neu aus Vorlage", "Öffnen")
                    )
                }

            }

        }
    }

}