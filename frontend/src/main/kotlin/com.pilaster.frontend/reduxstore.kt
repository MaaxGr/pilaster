package com.pilaster.frontend

import com.pilaster.frontend.components.AppState2
import org.reduxkotlin.*

val state2 = AppState2("leer")
val reducer: Reducer<AppState2> = { state , action ->

    if (action is String) {
        AppState2(action)
    } else {
        state
    }

}
val thunk = createThunkMiddleware<AppState2>()
val store = createStore(reducer, state2, applyMiddleware(thunk))

data class TestMessage(
        val string: String
)