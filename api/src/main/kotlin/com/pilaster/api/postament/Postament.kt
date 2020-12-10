package com.pilaster.api.postament

import com.pilaster.api.postament.dao.DAOProject
import com.pilaster.api.postament.dao.DAOTask
import com.pilaster.api.postament.dao.DAOTicket
import com.pilaster.common.Ticket
import org.flywaydb.core.Flyway
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

        val flyway = Flyway.configure().dataSource(url, user, secret).load()
        flyway.migrate()
    }
    fun recreate() {
        dropTables()
        createTables()
    }

    private fun createTables(){
        transaction {
            SchemaUtils.createMissingTablesAndColumns(DAOTask)
            SchemaUtils.createMissingTablesAndColumns(DAOTicket)
            SchemaUtils.createMissingTablesAndColumns(DAOProject)
        }
    }

    private fun dropTables(){
        transaction {
            SchemaUtils.drop(DAOTicket)
            SchemaUtils.drop(DAOTask)
            SchemaUtils.drop(DAOProject)
        }
    }

    fun getAllTickets(): List<Ticket> {
        return transaction {
            DAOTicket.selectAll()
                    .map {
                        Ticket(
                                id = it[DAOTicket.id],
                                description = it[DAOTicket.description]
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