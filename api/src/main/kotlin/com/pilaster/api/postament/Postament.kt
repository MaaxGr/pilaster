package com.pilaster.api.postament

import com.pilaster.api.postament.dbo.DBOTicket
import com.pilaster.api.entities.Ticket
import com.pilaster.api.postament.dbo.DBOTask
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class Postament {

    private val url : String = "jdbc:mysql://vh07.maax.gr:3306/pilaster"
    private val driver : String = "com.mysql.jdbc.Driver"
    private val user : String = "pilaster"
    private val secret : String = System.getenv("magrdbpw")

    init {
        Database.connect(url=url, driver=driver, user=user, password=secret )
    }
    fun recreate() {
        dropTables()
        createTables()
    }

    private fun createTables(){
        transaction {
            SchemaUtils.createMissingTablesAndColumns(DBOTask)
            SchemaUtils.createMissingTablesAndColumns(DBOTicket)
        }
    }

    private fun dropTables(){
        transaction {
            SchemaUtils.drop(DBOTicket)
            SchemaUtils.drop(DBOTask)
        }
    }

    fun getAllTickets(): List<Ticket> {
        return transaction {
            DBOTicket.selectAll()
                    .map {
                        Ticket(
                                id = it[DBOTicket.id],
                                description = it[DBOTicket.description]
                        )
                    }
        }
    }
}

fun main(){
    Postament().apply {
        recreate()
    }
}