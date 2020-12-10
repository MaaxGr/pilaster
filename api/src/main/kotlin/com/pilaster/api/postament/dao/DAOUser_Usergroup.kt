package com.pilaster.api.postament.dao

import org.jetbrains.exposed.sql.Table

object DAOUser_Usergroup : Table("User_Usergroup"){
    var userID = integer("UserID")
    var usergroupID = integer("UsergroupID")

    override val primaryKey = PrimaryKey(userID, usergroupID)
}