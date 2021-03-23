package com.pilaster.frontend.components.state.ribbon

data class RibbonTabState(
    val title:String,
    val isStatic:Boolean,
    val targetSection:String,
    val onClickAction: () -> Unit = {},
    val onDoubleClickAction: () -> Unit = {}
)
