package com.pilaster.frontend.components

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.a


external interface TabProps: RProps {
    var title: String
}

class Tab : RComponent<TabProps, RState>() {


    override fun RBuilder.render() {
        a{
            setProp("href","#_home_")
            +props.title
        }
    }
}