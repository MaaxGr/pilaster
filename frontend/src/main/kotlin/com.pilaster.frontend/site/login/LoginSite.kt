package com.pilaster.frontend.site.login

import com.pilaster.frontend.site.login.form.LoginFrm
import kotlinx.css.*
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.*
import styled.css
import styled.styledDiv
import styled.styledSpan

class LoginSite : RComponent<RProps,RState>() {

    override fun RBuilder.render() {
        div(classes = "container") {
            setProp("id","LoginSite")

            styledDiv {
                setProp("id","LoginLogo")
                css {
                    width = 20.pct
                    margin = "0 auto"
                }
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
            child(LoginFrm::class){}
        }
    }
}