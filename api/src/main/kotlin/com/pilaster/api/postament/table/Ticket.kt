package com.pilaster.api.postament.table

import org.jetbrains.exposed.sql.Table

object Ticket : Table() {

    val id = integer("id")
    val description = varchar("description", length = 200)

    override val primaryKey = PrimaryKey(id)

}