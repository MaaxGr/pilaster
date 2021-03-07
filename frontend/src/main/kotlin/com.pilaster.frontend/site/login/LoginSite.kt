package com.pilaster.frontend.site.login

import com.pilaster.frontend.site.login.form.LoginFrm
import kotlinx.browser.document
import kotlinx.css.*
import kotlinx.html.DIV
import org.w3c.dom.WebSocket
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.*
import styled.css
import styled.styledDiv
import styled.styledSpan

class LoginSite : RComponent<RProps,RState>() {

    fun start(){
        render(document.getElementById("root")) {
            child(LoginSite::class) {}
        }
        renderLogo("LoginLogo")

        println("----- Jetzt kommt der Websocket ------")
        //Todo: Verschlüsseln (wss://)
        val testWS = WebSocket(url = "ws://localhost:8448/WS")

        testWS.onopen = {
            println("Geöffnet")
            testWS.send("Hallo!")
        }

        testWS.onmessage = {
            println("Nachricht")
            println(it.data)
        }

        testWS.onerror = {
            println("FEHLER!")
        }

        testWS.onclose = {
            println("Geschlossen")
        }






    }



    override fun RBuilder.render() {

        div(classes = "container") {
            setProp("id","LoginSite")

            styledDiv {
                setProp("id","LoginLogo")
                css {
                    width = 20.pct
                    margin = "0 auto"
                }
            }
            child(LoginFrm::class){}
        }

    }

    fun renderLogo(targetId: String) {
        render(document.getElementById(targetId)) {
            h3 {
                small {
                    styledSpan{ css { paddingRight = 12.px }; + "8448" }
                    styledSpan{ css { paddingRight = 12.px }; + "8448" }
                    styledSpan{ css { paddingRight = 12.px }; + "8448" }
                    br {  }
                    styledSpan{ css { paddingLeft = 10.px; paddingRight = 14.px }; + "| | |" }
                    styledSpan{ css { paddingLeft = 18.px; paddingRight = 14.px }; + "| | |" }
                    styledSpan{ css { paddingLeft = 18.px }; + "| | |" }
                    br {  }
                    styledSpan{ css { paddingLeft = 10.px; paddingRight = 14.px }; + "| | |" }
                    styledSpan{ css { paddingLeft = 18.px; paddingRight = 14.px }; + "| | |" }
                    styledSpan{ css { paddingLeft = 18.px }; + "| | |" }
                    br{}
                    styledSpan{ css { paddingLeft = 10.px; paddingRight = 14.px }; + "| | |" }
                    styledSpan{ css { paddingLeft = 18.px; paddingRight = 14.px }; + "| | |" }
                    styledSpan{ css { paddingLeft = 18.px }; + "| | |" }
                    br {  }
                    styledSpan{ css { paddingRight = 12.px }; + "8448" }
                    styledSpan{ css { paddingRight = 12.px }; + "8448" }
                    styledSpan{ css { paddingRight = 12.px }; + "8448" }
                }
            }
        }
    }
}