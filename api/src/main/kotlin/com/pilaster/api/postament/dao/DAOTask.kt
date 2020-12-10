package com.pilaster.api.postament.dao

import org.jetbrains.exposed.sql.Table

object DAOTask : Table("Task") {

    val taskid = integer("Taskid")
    val tasktext = text("Text")

    override val primaryKey = PrimaryKey(taskid)

}