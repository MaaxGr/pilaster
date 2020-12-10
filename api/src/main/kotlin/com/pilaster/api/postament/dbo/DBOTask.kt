package com.pilaster.api.postament.dbo

import org.jetbrains.exposed.sql.Table

object DBOTask : Table() {

    val taskid = integer("Taskid")
    val tasktext = text("Text")

    override val primaryKey = PrimaryKey(taskid)

}