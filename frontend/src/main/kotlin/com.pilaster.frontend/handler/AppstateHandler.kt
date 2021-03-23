package com.pilaster.frontend.handler

import com.pilaster.frontend.components.state.Appstate
import com.pilaster.frontend.components.state.AppstatePhase
import com.pilaster.frontend.components.state.content.ViewState
import com.pilaster.frontend.components.state.ribbon.RibbonState
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
                state.copy(phase = action)
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

}