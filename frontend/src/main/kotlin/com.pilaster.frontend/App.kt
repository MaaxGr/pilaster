package com.pilaster.frontend

import com.pilaster.frontend.components.charms.CharmsHandler
import com.pilaster.frontend.components.content.ContentHandler
import com.pilaster.frontend.components.ribbonmenu.RibbonMenuHandler
import com.pilaster.frontend.components.state.AppstateHandler
import com.pilaster.frontend.components.state.AppstatePhase
import com.pilaster.frontend.components.window.WindowHandler
import com.pilaster.frontend.handler.AuthentificationHandler
import com.pilaster.frontend.handler.BackendHandler
import com.pilaster.frontend.handler.SessionHandler
import com.pilaster.frontend.site.login.LoginSite
import kotlinx.browser.document
import kotlinx.css.*
import react.dom.div
import react.dom.render
import styled.css
import styled.styledDiv


class App {

    companion object {
        val appstate = AppstateHandler()
        val backend = BackendHandler()
        val session = SessionHandler()
        val authentification = AuthentificationHandler()
    }

    init {
        appstate.store.subscribe() {
            onStateChange()
        }
        appstate.store.dispatch("Init")

    }

    private fun onStateChange() {
        println("Statechange => ${appstate.store.state}")

        when (appstate.store.state.phase) {
            AppstatePhase.LOGIN -> {
                createLoginStructure()
            }
            AppstatePhase.MAIN -> {
                createMainStructure()
            }
        }
    }

    private fun createLoginStructure() {
        render(document.getElementById("root")) {
            child(LoginSite::class) {}
        }

    }

    private fun createMainStructure() {
        render(document.getElementById("root")) {
            styledDiv {
                setProp("id", "Kopf")
                css {
                    position = Position.relative
                }
                div {
                    setProp("id", "ribbonBarArea")
                }
            }

            styledDiv {
                setProp("id", "content-collection")
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

                styledDiv {
                    setProp("id", "windowArea")
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

        }
        render(document.getElementById("ribbonBarArea")) {
            child(RibbonMenuHandler::class) {
            }
        }

        render(document.getElementById("contentArea")) {
            child(ContentHandler::class) {
            }
        }

        render(document.getElementById("charmsArea")) {
            child(CharmsHandler::class) {
            }
        }

    }

}

//class App : RComponent<RProps, AppState>() {
//external interface AppState: RState {
//    var ticket: TicketList?
//    var contentType: String
//    var loggedIn: Boolean
//}

/*
    override fun AppState.init() {


        store.subscribe {
            setState {
                loggedIn = store.state.loggedIn
            }
        }
    }


    override fun RBuilder.render() {

        when (store.state.phase){

            "Login"-> {
                render(document.getElementById("root")) {
                    child(LoginSite::class) {}
                }
            }

//            "Main"-> {
//                styledDiv {
//                    setProp("id", "Kopf")
//                    css {
//                        position = Position.relative
//                    }
//                    div {
//                        setProp("id", "ribbonBarArea")
//                    }
//                }
//
//                styledDiv {
//                    setProp("id", "content-collection")
//                    css {
//                        position = Position.relative
//                        minHeight = 100.pct
//                    }
//                    styledDiv {
//                        setProp("id", "contentArea")
//                        css {
//                            minHeight = 100.pct
//                            minWidth = 100.pct
//                            position = Position.absolute
//                        }
//                    }
//
//                    styledDiv {
//                        setProp("id", "windowArea")
//                        //setProp("class","container")
//                        css {
//                            minHeight = 100.pct
//                            minWidth = 100.pct
//                            position = Position.absolute
//                        }
//
//                        child(WindowHandler::class) {
//                        }
//                    }
//                }
//
//
//
//                div {
//                    setProp("id", "charmsArea")
//                }
//
//
//                render(document.getElementById("ribbonBarArea")) {
//                    child(RibbonMenuHandler::class) {
//                    }
//                }
//
//                render(document.getElementById("contentArea")) {
//                    child(ContentHandler::class) {
//                    }
//                }
//
//                render(document.getElementById("charmsArea")) {
//                    child(CharmsHandler::class) {
//                    }
//                }
//
//            }
//
//
//
//
//
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
*/