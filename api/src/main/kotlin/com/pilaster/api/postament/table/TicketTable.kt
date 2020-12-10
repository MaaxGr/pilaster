package com.pilaster.api.postament.table

import org.jetbrains.exposed.sql.Table

object TicketTable : Table() {

    val number = integer("Number")
    val title = varchar("Title", length = 500)
    val description = text("description")

    override val primaryKey = PrimaryKey(number)

}