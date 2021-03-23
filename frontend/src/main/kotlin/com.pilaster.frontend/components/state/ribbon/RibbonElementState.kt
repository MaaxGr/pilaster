package com.pilaster.frontend.components.state.ribbon

data class RibbonElementState(
    val targetSection: String,
    val tileGroup:String,
    val buttonText:String,
    var onClickAction : () -> Unit = {}
)
