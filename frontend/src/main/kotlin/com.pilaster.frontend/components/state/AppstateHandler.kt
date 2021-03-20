package com.pilaster.frontend.components.state

import org.reduxkotlin.applyMiddleware
import org.reduxkotlin.createStore
import org.reduxkotlin.createThunkMiddleware

class AppstateHandler {


    val store = createStore(this::rootReducer,Appstate(), applyMiddleware(createThunkMiddleware<Appstate>()))

    init {

    }


    private fun rootReducer(state:Appstate, action:Any) :Appstate {
        return when (action) {
            is AppstatePhase -> {
                state.copy(phase = action)
            }
            else->{
                state
            }
        }

    }

}