package com.pilaster.frontend.components.content

import com.pilaster.frontend.components.AppState
import react.RBuilder
import react.RComponent
import react.RProps
import react.dom.h1

class ContentTicket : RComponent<RProps,AppState>() {
    override fun RBuilder.render() {
        h1{
            +"Hier kommen die Tickets"
        }
    }
}