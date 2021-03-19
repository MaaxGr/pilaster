package com.pilaster.frontend.site.login.form

import com.pilaster.frontend.handler.AuthHandler
import com.pilaster.frontend.store
import kotlinx.browser.document
import kotlinx.html.InputType
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLInputElement
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

        div {
            setProp("id", "loginFrm")
            form {
                div {
                    setProp("class", "form-group")
                    label {
                        +"Anmeldename"
                    }
                    input(classes = "metro-input"){
                        setProp("id","username")
                        setProp("type", "text")
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
                        setProp("id","secret")
                        setProp("type","password")
                        setProp("class","metro-input")
                        setProp("data-role","input")
                        setProp("data-prepend","<span class='mif-lock'></span>")
                    }
                }
                div(classes = "form-group"){

                    button(classes = "button success") {
                        setProp("type","button")
                        if (state.backendConnection) {
                            + "Anmelden"
                            setProp("class", "button success")
                            attrs{
                                onClickFunction= {
                                    AuthHandler.performLogin(
                                        (document.getElementById("username") as HTMLInputElement).value,
                                        (document.getElementById("secret") as HTMLInputElement).value
                                    )
                                }
                            }
                        } else {
                            + "Anmelden"
                            setProp("class", "button alert disabled")
                        }
                    }

                    if (!state.backendConnection){
                        br {  }
                        small(classes = "text-muted") { + "Anmeldung nicht möglich: Backend nicht erreichbar" }
                    }
                }
            }
        }
    }
}