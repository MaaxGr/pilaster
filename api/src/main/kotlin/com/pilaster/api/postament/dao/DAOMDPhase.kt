package com.pilaster.api.postament.dao

import org.jetbrains.exposed.sql.Table

/*
Tickets, Projekte und Aufgaben können mehrere Phase durchwandern
Definition findet hier statt
Eine Phase entspricht NICHT einem Workflow, sondern beschreibt eine zeitliche Orientierung (z.B. Planungsphase)
 */
object DAOMDPhase : Table("Phase"){
    val phaseId = integer("PhaseID") //Datenbank-Zähler
    val phaseKey = varchar("phaseKey",15) //Kurzbezeichnung, sprechend
    val phaseName = varchar("PhaseName", 50) //Ausgeschriebener Name einer Phase
    val description = varchar("Description", 500) //Ausführlliche Beschreibung zu einer Phase

}