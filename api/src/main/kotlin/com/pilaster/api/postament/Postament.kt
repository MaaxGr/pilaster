package com.pilaster.api.postament

import com.pilaster.api.postament.table.Ticket
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

class Postament {

    private val url : String = "jdbc:mysql://localhost:3306/pilaster"
    private val driver : String = "com.mysql.jdbc.Driver"
    private val user : String = "pilaster"
    private val secret : String = "pilaster"

    init {
        Database.connect(url=url, driver=driver, user=user, password=secret )

        createTables()

        dropTables()

    }

    private fun createTables(){
        transaction {
            SchemaUtils.createMissingTablesAndColumns(Ticket)
        }
    }

    private fun dropTables(){
        transaction {
            SchemaUtils.drop(Ticket)
        }
    }

}

fun main(){
    Postament()
}