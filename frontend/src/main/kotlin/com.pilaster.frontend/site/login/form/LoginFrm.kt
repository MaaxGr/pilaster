package com.pilaster.frontend.site.login.form

import com.pilaster.frontend.store
import kotlinx.css.div
import kotlinx.html.InputType
import react.*
import react.dom.*

external interface LoginFromState : RState{
    var backendConnection: Boolean
}

class LoginFrm: RComponent<RProps, LoginFromState>() {
    override fun RBuilder.render() {

        store.subscribe {
            setState {
            backendConnection = store.state.backend.isConnected
            }
        }

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
                        if (state.backendConnection) {
                            setProp("class", "button success")
                        } else {
                            setProp("class", "button alert disabled")
                        }
                    }
                }
            }
        }
    }
}