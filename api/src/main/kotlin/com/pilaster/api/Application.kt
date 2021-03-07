package com.pilaster.api

import com.pilaster.api.postament.Postament
import com.pilaster.common.TicketList
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.http.cio.websocket.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.websocket.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    val postament = Postament()

    install(ContentNegotiation) {
        gson {  }
    }

    install(DefaultHeaders)
    install(CORS) {
        method(HttpMethod.Options)
        method(HttpMethod.Get)
        method(HttpMethod.Post)
        method(HttpMethod.Put)
        method(HttpMethod.Delete)
        method(HttpMethod.Patch)
        header(HttpHeaders.AccessControlAllowHeaders)
        header(HttpHeaders.ContentType)
        header(HttpHeaders.AccessControlAllowOrigin)
        allowCredentials = true
        anyHost()

        header("Source")
        header("User")
        header("Token")
    }

    install(WebSockets){

    }

    routing {

        webSocket("/WS") {
            for (frame in incoming) {
                println("HUI")
                when (frame) {
                    is Frame.Text -> {
                        val text = frame.readText()
                        outgoing.send(Frame.Text("YOU SAID: $text"))
                        if (text.equals("bye", ignoreCase = true)) {
                            close(CloseReason(CloseReason.Codes.NORMAL, "Client said BYE"))
                        }
                    }
                }
            }
        }

        get("/") {
            call.respondText { "Hello Pilaster!" }
        }

        get("/db/recreate") {
            postament.recreate()
        }

        get("/tickets") {
            call.respond(TicketList(postament.getAllTickets().toTypedArray()))
        }

        get("/tickets/first") {
            call.respond(postament.getAllTickets().first())
        }

    }

}

