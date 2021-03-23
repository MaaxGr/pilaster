package com.pilaster.frontend.handler

import com.pilaster.frontend.App
import com.pilaster.frontend.components.state.Appstate
import com.pilaster.frontend.components.state.AppstatePhase
import com.pilaster.frontend.components.state.content.ViewState
import com.pilaster.frontend.components.state.ribbon.RibbonState
import com.pilaster.frontend.components.state.ribbon.RibbonTabState
import org.reduxkotlin.applyMiddleware
import org.reduxkotlin.createStore
import org.reduxkotlin.createThunkMiddleware

class AppstateHandler {


    val store = createStore(this::rootReducer, Appstate(), applyMiddleware(createThunkMiddleware<Appstate>()))

    init {

    }


    private fun rootReducer(state: Appstate, action:Any) : Appstate {
        return when (action) {
            is AppstatePhase -> {
                when(action){
                    AppstatePhase.MAIN->{
                        state.copy(phase = action, ribbon = afterLoginRibbon())
                    }
                    else->{
                        state.copy(phase = action, ribbon = initiateRibbon())
                    }
                }

            }
            is RibbonState->{
                state.copy(ribbon = action)
            }
            is ViewState->{
                println("NewViewState: $action")
                state.copy(contentView = action)
            }
            else->{
                state
            }
        }

    }
    fun initiateRibbon():RibbonState{
        return RibbonState(
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

    }

    fun afterLoginRibbon():RibbonState{ //TMP!!
        return RibbonState(
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

    }

}