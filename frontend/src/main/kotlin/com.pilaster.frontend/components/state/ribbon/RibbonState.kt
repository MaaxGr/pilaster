package com.pilaster.frontend.components.state.ribbon

data class RibbonState(
    val tabs :List<RibbonTabState> = listOf(),
    val elements: List<RibbonElementState> = listOf(),

    )
