package com.pilaster.api.postament.dao

import org.jetbrains.exposed.sql.Table

object DAOTicket : Table("Ticket") {

    val id = integer("ID")
    val title = varchar("Title", length = 500)
    val description = text("Description")

    override val primaryKey = PrimaryKey(id)

}