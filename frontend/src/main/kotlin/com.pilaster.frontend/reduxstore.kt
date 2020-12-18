package com.pilaster.frontend

import com.pilaster.frontend.components.state.AppState
import com.pilaster.frontend.components.state.CharmsState
import org.reduxkotlin.*

val state2 = AppState()
val reducer: Reducer<AppState> = { state , action ->
    state
    /*
    if (action is String) {
        AppState(CharmsState(open=true), "")
    } else {
        state
    }
*/
}
val thunk = createThunkMiddleware<AppState>()
val store = createStore(reducer, state2, applyMiddleware(thunk))
