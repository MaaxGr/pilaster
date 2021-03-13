package com.pilaster.frontend.components.state

import com.pilaster.frontend.components.CharmsEnum

class AppState {
    var charms:MutableMap<CharmsEnum,CharmsState> = mutableMapOf(
        CharmsEnum.TASKBAR to CharmsState()
    )
    var contentArea:String = ""

    // Allgemeine Statusinfos über die Verbindung zum Backend
    val backend = BackendState()
}
