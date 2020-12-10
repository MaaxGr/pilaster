package com.pilaster.frontend.components

import com.pilaster.frontend.entities.TicketList
import kotlinx.browser.window
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.await
import kotlinx.coroutines.launch
import react.*
import react.dom.*

external interface AppState: RState {
    var ticket: TicketList?
}

class App : RComponent<RProps, AppState>() {

    override fun AppState.init() {
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

    private suspend fun fetchTickets(): TicketList {
        val json = window.fetch("http://localhost:8448/tickets")
                .await()
                .json()
                .await()
        println(JSON.stringify(json))

        return json.unsafeCast<TicketList>()
    }

}
