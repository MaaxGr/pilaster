package com.pilaster.frontend.components

import react.RBuilder
import react.RComponent
import react.RState
import react.dom.*

class TopMenu : RComponent<TabProps, RState>() {

    override fun RBuilder.render() {
        nav {
            setProp("data-role", "ribbonmenu")
            ul {
                setProp("class", "tabs-holder")
                li {
                    setProp("class", "static")
                    a {
                        setProp("href", "#_home_")
                        +"Home"
                    }
                }
                li {
                    a {
                        setProp("href", "#_section_projects_")
                        //setProp("class", "disabled")
                        +"Projekte"
                    }
                }
                li {
                    a {
                        setProp("href", "#_section_tickets_")
                        +"Tickets"
                    }
                }
            }

            // Content Section
            div {
                setProp("class", "content-holder")
                div {
                    setProp("class", "section")
                    setProp("id", "_section_projects_")
                    p {
                        +"Sektion -> Projekte"
                    }
                }

                div {
                    setProp("class", "section")
                    setProp("id", "_section_tickets_")
                    div {
                        setProp("class", "group")
                        button {
                            setProp("class", "ribbon-button")
                            span {
                                setProp("class", "mif-star-full")
                            }
                            span {
                                setProp("class", "caption")
                                +"Alle Tickets!"
                            }
                        }

                        button {
                            setProp("class", "ribbon-button")
                            span {
                                setProp("class", "mif-star-full")
                            }
                            span {
                                setProp("class", "caption")
                                +"Neue Tickets!"
                            }
                        }

                        button {
                            setProp("class", "ribbon-button")
                            span {
                                setProp("class", "mif-star-full")
                            }
                            span {
                                setProp("class", "caption")
                                +"Mir zugewiesen"
                            }
                        }

                        span {
                            setProp("class", "title")
                            +"Öffnen"
                        }
                    }


                    div {
                        setProp("class","group")

                        button {
                            setProp("class", "ribbon-button")
                            span {
                                setProp("class", "mif-star-full")
                            }
                            span {
                                setProp("class", "caption")
                                +"Neu Blanko"
                            }
                        }

                        button {
                            setProp("class", "ribbon-button")
                            span {
                                setProp("class", "mif-star-full")
                            }
                            span {
                                setProp("class", "caption")
                                +"Neue aus Vorlage"
                            }
                        }

                        span {
                            setProp("class", "title")
                            +"Erstellen"
                        }

                    }

                }

            }


            /*
            ul {
                setProp("class", "h-menu")
                setProp("data-role", "tabs")
                setProp("data-expand", "true")


                /*
                child(Tab::class) {
                    attrs.title = "Home"
                }

            }
*/*/
        }
    }

}