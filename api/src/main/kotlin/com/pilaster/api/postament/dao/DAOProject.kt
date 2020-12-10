package com.pilaster.api.postament.dao

import org.jetbrains.exposed.sql.Table

object DAOProject :Table("Project") {

    val projectId = integer("ProjectID")
    val projectName = varchar("ProjectName", 100)
    val description = text("Description")

    override val primaryKey = PrimaryKey(projectId)

}