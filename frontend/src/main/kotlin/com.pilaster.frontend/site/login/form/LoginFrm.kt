package com.pilaster.frontend.site.login.form

import kotlinx.css.div
import kotlinx.html.InputType
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.*

class LoginFrm: RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div (){
            setProp("id", "loginFrm")
            form {
                div {
                    setProp("class", "form-group")
                    label {
                        +"Anmeldename"
                    }
                    input(type = InputType.button) {

                        setProp("type", "text")
                        setProp("class", "metro-input")
                        setProp("data-role","input")
                        setProp("data-prepend","<span class='mif-user'></span>")
                    }
                }
                div {
                    setProp("class", "form-group")
                    label{
                        +"Kennwort"
                    }
                    input {
                        setProp("type","password")
                        setProp("class","metro-input")
                        setProp("data-role","input")
                        setProp("data-prepend","<span class='mif-lock'></span>")
                    }
                }
                div(classes = "form-group"){
                    button(classes = "button success") {
                        + "Anmelden"
                        setProp("type","button")
                    }
                }
            }
        }
    }
}