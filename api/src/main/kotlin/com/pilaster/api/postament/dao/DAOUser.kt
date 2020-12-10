package com.pilaster.api.postament.dao

import org.jetbrains.exposed.sql.Table

object DAOUser : Table("User"){

    var userID = integer("UserID")
    var nickname = varchar("Nickname", 35)
    var firstname = varchar("Firstname", 35)
    var lastname = varchar("Lastname", 35)
    var secret = varchar("Secret", 35)

    override val primaryKey = PrimaryKey(userID)
}