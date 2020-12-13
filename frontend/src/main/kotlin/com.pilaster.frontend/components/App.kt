package com.pilaster.frontend.components

import com.pilaster.common.TicketList
import com.pilaster.frontend.components.ribbonmenu.TopMenuHandler
import com.pilaster.frontend.store
import kotlinx.browser.window
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.await
import kotlinx.coroutines.launch
import org.reduxkotlin.Reducer
import org.reduxkotlin.Store
import org.reduxkotlin.createStore
import react.*
import react.dom.*

external interface AppState: RState {
    var ticket: TicketList?
}

data class AppState2(
        val message: String
)

class App : RComponent<RProps, AppState>() {

    init {

    }


    override fun AppState.init() {

        store.subscribe {
            println("Edit: " + store.state.message)
        }

        console.log("fetch ticekts")
        MainScope().launch {

            val fetchedTicket = fetchTickets()

            println("Ticket: $fetchedTicket")

            setState {
                ticket = fetchedTicket
            }



        }

    }


    override fun RBuilder.render() {

        // Topmenü zeichnen
        child(TopMenuHandler::class) {
            //attrs.title = "Home"
        }


/*
        div{
            setProp("class","border bd-default no-border-top p-2")
            div {
                setProp("id","_home_")
                div {
                    setProp("data-role","cube")
                }
            }
            div {
                setProp("id","_tickets_")
                h1 {
                    +"Tickets"
                }
                div {
                    state.ticket?.let { ticketList ->

                        h2 { +"Ticket-Anzahl: ${ticketList.tickets.size}" }

                        ul {

                            for (ticket in ticketList.tickets) {
                                li { +"Ticket #${ticket.id}: ${ticket.description}" }
                            }

                        }
                    }


                }
            }
        }
*/
    }

    private suspend fun fetchTickets(): TicketList {
        val json = window.fetch("http://localhost:8448/tickets")
                .await()
                .json()
                .await()
        println(JSON.stringify(json))

        return json.unsafeCast<TicketList>()
    }

}
