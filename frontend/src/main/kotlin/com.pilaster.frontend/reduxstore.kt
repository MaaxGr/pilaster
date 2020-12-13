package com.pilaster.frontend

import com.pilaster.frontend.components.AppState2
import org.reduxkotlin.*

val state2 = AppState2("leer", "Home")
val reducer: Reducer<AppState2> = { state , action ->

    if (action is String) {
        AppState2(action, action)
    } else {
        state
    }

}
val thunk = createThunkMiddleware<AppState2>()
val store = createStore(reducer, state2, applyMiddleware(thunk))
