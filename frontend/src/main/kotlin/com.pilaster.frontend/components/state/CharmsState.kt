package com.pilaster.frontend.components.state

import com.pilaster.frontend.store

// Im Stnadard ist alles aus!
class CharmsState(
    var open: Boolean = false
) {
    val _open: String
        get() {
            return if (open) {
                "open"
            } else {
                ""
            }
        }

    fun toggleOpen() {
        open = !open
    }

}