package com.pilaster.api.postament

import com.pilaster.api.entities.Ticket
import com.pilaster.api.postament.table.TicketTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class Postament {

    private val url : String = "jdbc:mysql://localhost:3306/pilaster"
    private val driver : String = "com.mysql.jdbc.Driver"
    private val user : String = "pilaster"
    private val secret : String = "pilaster"

    init {
        Database.connect(url=url, driver=driver, user=user, password=secret )
    }
    fun recreate() {
        dropTables()
        createTables()
    }

    private fun createTables(){
        transaction {
            SchemaUtils.createMissingTablesAndColumns(TicketTable)
        }
    }

    private fun dropTables(){
        transaction {
            SchemaUtils.drop(TicketTable)
        }
    }

    fun getAllTickets(): List<Ticket> {
        return transaction {
            TicketTable.selectAll()
                    .map {
                        Ticket(
                                id = it[TicketTable.id],
                                description = it[TicketTable.description]
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