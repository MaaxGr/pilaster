package com.pilaster.frontend

import com.pilaster.frontend.components.state.AppState_old
import org.reduxkotlin.*

val state2 = AppState_old()
val REDUCER: Reducer<AppState_old> = { state, action ->
    state
/*
    if (action is String) {
        AppState(CharmsState(open=true), "")
    } else {
        state
    }
*/
}
val thunk = createThunkMiddleware<AppState_old>()
val store = createStore(REDUCER, state2, applyMiddleware(thunk))
