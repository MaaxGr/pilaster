package com.pilaster.frontend.site.component.ribbon

import com.pilaster.frontend.components.state.content.ViewState
import com.pilaster.frontend.store
import kotlinx.browser.window
import kotlinx.html.js.onClickFunction
import kotlinx.html.js.onDoubleClickFunction
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.a
import react.dom.li

external interface RibbonTabProps : RProps {
    var title: String
    var isStatic: Boolean
    var targetSection: String
    var onClickAction: () -> Unit

    var disabled : Boolean
}

class RibbonTab : RComponent<RibbonTabProps, RState>() {
    override fun RBuilder.render() {
        li {
            if (props.isStatic) {
                setProp("class", "static")
            }
            a {
                setProp("href", "#" + props.targetSection)
                if(props.disabled){
                    setProp("class","disabled")
                }
                +props.title
                attrs {
                    onDoubleClickFunction= {
                        window.alert("Doppelklick")
                    }
                }

                when(props.title) {
                    //if(props.title == "Home"){
                    "Home" -> {
                        //store.state.contentArea = "Home"
                        //store.dispatch("Dummy")

                        attrs {
                            onClickFunction = {
                                store.state.contentArea = "Home"
                                store.dispatch("Dummy")
                            }
                        }
                    }
                    "Tickets" ->{
                        //store.state.contentArea = "Ticket"
                        //store.dispatch("Dummy")
                        attrs {
                            onClickFunction = {
                                store.state.contentArea = "Ticket"
                                store.dispatch("Dummy")
                            }
                        }
                    }
                    "Projekte" -> {
                        attrs {
                            onClickFunction = {
                                store.state.contentArea = "Project"
                                store.dispatch("Dummy")
                            }
                        }
                    }
                }

            }
        }
    }
}