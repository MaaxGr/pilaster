package com.pilaster.frontend.site.main

import com.pilaster.frontend.App
import com.pilaster.frontend.components.content.ContentHome
import com.pilaster.frontend.components.content.ContentProject
import com.pilaster.frontend.components.content.ContentTicket
import com.pilaster.frontend.components.content.ContentTicketDetail
import com.pilaster.frontend.components.state.content.ViewState
import react.*


external interface MainSiteState: RState {

    var currentView: ViewState
}

class MainSite : RComponent<RProps,MainSiteState>(){
    override fun RBuilder.render() {
        state.currentView = App.appstate.store.state.contentView
        App.appstate.store.subscribe{
            setState{
                currentView = App.appstate.store.state.contentView
            }
        }

        when(state.currentView){
            ViewState.HOME->{
                child(ContentHome::class) {}
            }
            ViewState.PROJECT->{
                child(ContentProject::class) {}
            }
            ViewState.TICKET->{
                child(ContentTicket::class) {}
            }
            ViewState.TICKETDETAIL->{
                child(ContentTicketDetail::class) {}
            }
        }

    }
}