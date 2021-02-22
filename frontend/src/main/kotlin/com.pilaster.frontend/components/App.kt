package com.pilaster.frontend.components

import com.pilaster.common.TicketList
import com.pilaster.frontend.components.window.WindowHandler
import com.pilaster.frontend.store
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.await
import kotlinx.coroutines.launch
import react.*
import react.dom.*

external interface AppState: RState {
    var ticket: TicketList?
    var contentType: String
}

class App : RComponent<RProps, AppState>() {

    override fun AppState.init() {

        store.subscribe {
            //println("Edit: " + store.state.message)
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


        div {
            setProp("id","ribbonBarArea")
        }

        div {
            setProp("id", "contentArea")


        }

        div {
            setProp("id", "charmsArea")
        }


            child(WindowHandler::class) {
            }




        //render(document.getElementById("ribbonBarArea")) {
        //    child(TopMenuHandler::class) {
        //    }
        //}

        //Ribbon-Menü
        //child(TopMenuHandler::class) {
        //}



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
