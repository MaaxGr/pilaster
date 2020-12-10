package com.pilaster.api.postament.dbo

import org.jetbrains.exposed.sql.Table

object DBOTicket : Table() {

    val id = integer("id")
    val title = varchar("Title", length = 500)
    val description = text("description")

    override val primaryKey = PrimaryKey(id)

}