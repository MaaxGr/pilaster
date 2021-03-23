package com.pilaster.frontend.components.state

import com.pilaster.frontend.components.state.content.ViewState
import com.pilaster.frontend.components.state.ribbon.RibbonState

data class Appstate (
    val phase:AppstatePhase = AppstatePhase.UNDEFINED,
    val ribbon: RibbonState = RibbonState(),

    val contentView: ViewState = ViewState.HOME
        )