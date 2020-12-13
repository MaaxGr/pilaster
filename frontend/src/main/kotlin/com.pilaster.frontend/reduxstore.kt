package com.pilaster.frontend

import com.pilaster.frontend.components.AppState2
import org.reduxkotlin.Reducer
import org.reduxkotlin.Store
import org.reduxkotlin.createStore

val state2 = AppState2("leer")
val reducer: Reducer<AppState2> = { state, action ->
    if (action is TestMessage) {
        state.copy(message = action.string)
    }
    state
}

val store = createStore(reducer, state2)

data class TestMessage(
        val string: String
)