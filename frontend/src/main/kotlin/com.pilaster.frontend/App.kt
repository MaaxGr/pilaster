package com.pilaster.frontend

import com.pilaster.common.TicketList
import com.pilaster.frontend.components.window.WindowHandler
import com.pilaster.frontend.handler.ConnHandler
import com.pilaster.frontend.site.login.LoginSite
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.await
import kotlinx.coroutines.launch
import kotlinx.css.*
import react.*
import react.dom.*
import styled.css
import styled.styledDiv

external interface AppState: RState {
    var ticket: TicketList?
    var contentType: String
}

class App : RComponent<RProps, AppState>() {

    init {
        ConnHandler.connectToBackend() {

            LoginSite().start()
        }
    }

    override fun AppState.init() {

        store.subscribe {
            //println("Edit: " + store.state.message)
        }

//        console.log("fetch ticekts")
//        MainScope().launch {
//
//            val fetchedTicket = fetchTickets()
//
//            println("Ticket: $fetchedTicket")
//
//            setState {
//                ticket = fetchedTicket
//            }
//
//        }
    }


    override fun RBuilder.render() {

        styledDiv {
            setProp("id","Kopf")
            css {
                position = Position.relative
            }
            div {
                setProp("id","ribbonBarArea")
            }
        }

        styledDiv {
            setProp("id","content-collection")
            css {
                position = Position.relative
                minHeight = 100.pct
            }
            styledDiv {
                setProp("id", "contentArea")
                css {
                    minHeight = 100.pct
                    minWidth = 100.pct
                    position = Position.absolute
                }
            }

            styledDiv{
                setProp("id","windowArea")
                //setProp("class","container")
                css {
                    minHeight = 100.pct
                    minWidth = 100.pct
                    position = Position.absolute
                }

                child(WindowHandler::class) {
                }
            }
        }



        div {
            setProp("id", "charmsArea")
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
