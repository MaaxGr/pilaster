package com.pilaster.frontend.components.content


import com.pilaster.frontend.store
import react.*
import react.dom.h3

external interface ContentHandlerProps : RProps{
    //var renderContent : String
}

external interface ContentHandlerState: RState {
    var renderContent : String
}

class ContentHandler : RComponent<ContentHandlerProps, ContentHandlerState>() {
    override fun RBuilder.render() {

        store.subscribe {
            //println("ContentHandler: " + store.state.contentArea)
            setState{
                renderContent = store.state.contentArea
            }
            //props.renderContent = store.state.contentArea
        }



        h3 {
            +"Das ist der Content: "
            +state.renderContent
        }

        when (state.renderContent) {
            "Home" -> {
                child(ContentHome::class) {}
            }
            "Ticket" -> {
                child(ContentTicket::class) {}
            }

        }


    }
}