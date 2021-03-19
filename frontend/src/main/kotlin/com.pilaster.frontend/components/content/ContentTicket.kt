package com.pilaster.frontend.components.content

import com.pilaster.frontend.AppState
import com.pilaster.frontend.store
import kotlinx.html.js.onDoubleClickFunction
import react.RBuilder
import react.RComponent
import react.RProps
import react.dom.*

class ContentTicket : RComponent<RProps, AppState>() {
    override fun RBuilder.render() {

        table("table row-hover") {
            thead {
                tr {
                    th { +"#" }
                    th { +"Title" }
                }
            }
            tbody {
                tr("") {
                    attrs {
                        onDoubleClickFunction = {
                            store.state.contentArea = "TicketDetail"
                            store.dispatch("Dummy")
                        }
                    }
                    td { +"1" }
                    td { +"Testticket 1" }
                }
                tr("") {
                    td { +"2" }
                    td { +"Testticket 2" }
                }
                tr("") {
                    td { +"3" }
                    td { +"Testticket 3" }
                }
            }
        }
    }
}