package com.pilaster.api.postament.dbo

import org.jetbrains.exposed.sql.Table

object DBOProject :Table("Project") {

    val projectId = integer("ProjectId")
    val projectName = varchar("ProjectName", 100)
    val description = text("Text")

    override val primaryKey = PrimaryKey(projectId)

}