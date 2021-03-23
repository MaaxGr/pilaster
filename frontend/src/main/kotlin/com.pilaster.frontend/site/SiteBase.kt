package com.pilaster.frontend.site

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div

class SiteBase : RComponent<RProps,RState>(){
    override fun RBuilder.render() {
        div {
            setProp("id", "headArea")
            div(classes="row") {
                div(classes = "cell-12"){
                    setProp("id", "ribbonBarHead")
                }
            }
            div(classes="row") {
                div(classes = "cell-12") {
                    setProp("id", "ribbonBarContent")
                }
            }
        }

        div(classes = "row no-gap") {
            setProp("id","contentFrame")
            div(classes = "cell-12"){
                setProp("id", "contentArea")
            }
        }



        div {
            setProp("id", "charmsArea")
        }
    }
}