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

        ul {
            setProp("class", "h-menu")
            setProp("data-role", "tabs")
            setProp("data-expand", "true")

            li{
                a{
                    setProp("href","#_home_")
                    +"Home"
                }
            }
            li{
                a{
                    setProp("href","#_projects")
                    setProp("class","disabled")
                    +"Projekte"
                }
            }
            li{
                a{
                    setProp("href","#_tickets_")
                    +"Tickets"
                }
            }
        }
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
