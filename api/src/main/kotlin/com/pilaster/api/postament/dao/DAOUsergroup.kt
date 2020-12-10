package com.pilaster.api.postament.dao

import org.jetbrains.exposed.sql.Table

object DAOUsergroup : Table("Usergroup") {

    var groupID = integer("GroupID")
    var groupName = varchar("GroupName", 35)

    override val primaryKey = PrimaryKey(groupID)
}