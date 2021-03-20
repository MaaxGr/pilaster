package com.pilaster.frontend.components.content

import kotlinx.css.*
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.*
import styled.css
import styled.styledDiv

class ContentProject : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        h1{
            +"Hier sind die Projekte"
        }

        //Grid
        styledDiv{
            css {
                margin = "20px"
            }
            setProp("class","grid")
            styledDiv {
                css {
                    maxHeight =130.px
                }
                setProp("class","row")
                styledDiv {
                    css {
                        maxWidth = 150.px
                    }
                    setProp("class","cell")

                    //Beginn InfoBox --Projekt--
                    div {
                        setProp("class","more-info-box bg-gray fg-white")
                        div{
                            setProp("class","content")
                            h4{
                                setProp("class","text-bold mb-4")
                                + "Projekt"
                            }
                            div {
                                + "Details"
                            }
                        }
                    }
                    //--Ende InfoBox --Projekt--
                }

                //Beginn Payload 1-1
                styledDiv {
                    css {
                        maxWidth = 300.px
                    }
                    setProp("class","cell-2")
                    div {
                        setProp("class", "more-info-box bg-green fg-white")
                        div {
                            setProp("class", "content")
                            h5 {
                                setProp("class","mb-1")
                                +"Ausbau der Serverinfrasturktur"
                            }
                            div {
                                +"Netzwerktechnik"
                            }
                        }
                        a {
                            setProp("href", "#")
                            setProp("class", "more")
                            +"Zum Projekt "
                            span {
                                setProp("class", "mif-arrow-right")
                            }
                        }
                    }
                }
                //--Ende Payload 1-1
            }
            styledDiv {
                css {
                    maxHeight =130.px
                }
                setProp("class", "row")
                styledDiv {
                    css {
                        maxWidth = 150.px
                        maxHeight = 100.pct
                    }
                    setProp("class", "cell")
                    //Beginn InfoBox Fortschritt
                    div {
                        setProp("class","more-info-box bg-lightGray fg-white")
                        div{
                            setProp("class","content")
                            h4{
                                setProp("class","text-bold mb-0")
                                + "Fortschritt"
                            }
                        }
                    }
                    //--Ende InfoBox --Fortschritt--
                }

                //Beginn Payload 1-2
                    styledDiv {
                        setProp("class","cell")
                        css {
                            width = 300.px
                            maxHeight = 130.px

                        }
                        div{
                            setProp("data-role","donut")
                            setProp("data-value","25")
                            setProp("data-hole",".6")
                            setProp("data-stroke","#transparent")
                        }
                    }

                //--Ende Payload 1-2
            }

            div {
                setProp("class", "row")
                styledDiv {
                    css {
                        maxWidth = 150.px
                    }
                    setProp("class", "cell")
                    //Beginn InfoBox Zeitaufwand
                    div {
                        setProp("class","more-info-box bg-gray fg-white")
                        div{
                            setProp("class","content")
                            h4{
                                setProp("class","text-bold mb-0")
                                + "Zeitaufwand"
                            }
                        }
                    }
                    //--Ende InfoBox --Zeitaufwand--
                }
            }
            div {
                setProp("class", "row")
                styledDiv {
                    css {
                        maxWidth = 150.px
                    }
                    setProp("class", "cell")
                    //Beginn InfoBox Budget
                    div {
                        setProp("class","more-info-box bg-lightGray fg-white")
                        div{
                            setProp("class","content")
                            h4{
                                setProp("class","text-bold mb-0")
                                + "Budget"
                            }
                        }
                    }
                    //--Ende InfoBox --Budget--
                }
            }
        }



        //Beginn Container
        styledDiv {
            setProp("class", "container")
            css {
                minWidth = 200.px
                width = 20.pct
            }
            //}



        }

    }
}