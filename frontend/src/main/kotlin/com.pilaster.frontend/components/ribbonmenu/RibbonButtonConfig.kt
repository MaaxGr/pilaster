package com.pilaster.frontend.components.ribbonmenu

data class RibbonButtonConfig (
        var buttonSays:String,
        var titlegroup:String,
        var onClickAction : () -> Unit = {}
        )
