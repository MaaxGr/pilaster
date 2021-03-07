package com.pilaster.frontend.components.content


import com.pilaster.frontend.store
import react.*

external interface ContentHandlerProps : RProps{
    //var renderContent : String
}

external interface ContentHandlerState: RState {
    var renderContent : String
}

class ContentHandler : RComponent<ContentHandlerProps, ContentHandlerState>() {
    override fun RBuilder.render() {

        store.subscribe {
            setState{
                renderContent = store.state.contentArea
            }
        }


        when (state.renderContent) {
            "Home" -> {
                child(ContentHome::class) {}
            }
            "Ticket" -> {
                child(ContentTicket::class) {}
            }
            "Project" -> {
                child(ContentProject::class) {}
            }

        }

    }
}