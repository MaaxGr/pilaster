package com.pilaster.frontend

import com.pilaster.frontend.components.charms.CharmsHandler
import com.pilaster.frontend.components.content.ContentHandler
import com.pilaster.frontend.components.ribbonmenu.RibbonMenuHandler
import com.pilaster.frontend.handler.AppstateHandler
import com.pilaster.frontend.components.state.AppstatePhase
import com.pilaster.frontend.components.state.content.ViewState
import com.pilaster.frontend.components.state.ribbon.RibbonElementState
import com.pilaster.frontend.components.state.ribbon.RibbonState
import com.pilaster.frontend.components.state.ribbon.RibbonTabState
import com.pilaster.frontend.handler.AuthentificationHandler
import com.pilaster.frontend.handler.BackendHandler
import com.pilaster.frontend.handler.SessionHandler
import com.pilaster.frontend.site.SiteBase
import com.pilaster.frontend.site.component.ribbon.RibbonHead
import com.pilaster.frontend.site.login.LoginSite
import com.pilaster.frontend.site.main.MainSite
import kotlinx.browser.document
import react.dom.render


class App {

    companion object {
        val appstate = AppstateHandler()
        val backend = BackendHandler()
        val session = SessionHandler()
        val authentification = AuthentificationHandler()
    }

    init {
        initiateRibbon()
        createBaseStructure()

        appstate.store.subscribe() {
            onStateChange()
        }
        appstate.store.dispatch(0)

    }

    private fun onStateChange() {
        println("Statechange => ${appstate.store.state}")

        when (appstate.store.state.phase) {
            AppstatePhase.LOGIN -> {
                createLoginStructure()
            }
            AppstatePhase.MAIN -> {
                createMainStructure()
            }
            else->{
                println("Undefinerte Appphase")
            }
        }
    }

    private fun createBaseStructure(){
        render(document.getElementById("root")) {
            child(SiteBase::class) {}
        }

        render(document.getElementById("ribbonBarHead")){
            child(RibbonHead::class){}
        }
    }

    private fun createLoginStructure() {
        render(document.getElementById("contentArea")) {
            child(LoginSite::class) {}
        }

    }

    private fun createMainStructure() {
        render(document.getElementById("contentArea")) {
            child(MainSite::class) {
            }
        }

        render(document.getElementById("charmsArea")) {
            child(CharmsHandler::class) {
            }
        }

    }


    private fun initiateRibbon(){
        appstate.store.dispatch(
            RibbonState(
                tabs= listOf(
                    RibbonTabState(
                        "pilaster",
                        false,
                        "_section_pilaster_"
                    ),
                    RibbonTabState(
                        "-[--]-",
                    false,
                    "_section_none_"
                    )
                )
            )
        )
    }

    fun afterLoginRibbon(){ //TMP!!
        appstate.store.dispatch(
            RibbonState(
                tabs= listOf(
                    RibbonTabState(
                        "pilaster",
                        false,
                        "_section_pilaster_"
                    ),
                    RibbonTabState(
                        "-[--]-",
                        false,
                        "_section_none_"
                    ),
                    RibbonTabState(
                        "Projekte",
                        false,
                        "_section_projects_",
                        {App.appstate.store.dispatch(ViewState.PROJECT)}
                    ),
                    RibbonTabState(
                        "Tickets",
                        false,
                        "_section_tickets_",
                        {App.appstate.store.dispatch(ViewState.TICKET)}
                    ),
                    RibbonTabState(
                        "Ansicht",
                        false,
                        "_section_ansicht_",
                    )
                )
            )
        )
    }

}
