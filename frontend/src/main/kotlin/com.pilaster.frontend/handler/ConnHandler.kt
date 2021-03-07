package com.pilaster.frontend.handler

import org.w3c.dom.WebSocket

object ConnHandler {

    private var isConnected:Boolean = false

    //TODO: Umstellen auf SSL (wss://)
    private val protocol = "ws://"
    private val url ="localhost:8448/WS"

    private lateinit var wsBackend : WebSocket

    fun connectToBackend(temp: () -> Unit){
        wsBackend = WebSocket(protocol + url)

        wsBackend.onopen ={
            println("Websocket geöffnet")
            setConStatus(true)
            temp.invoke()
        }

        wsBackend.onclose = {
            println("Websocket geschlossen")
            setConStatus(false)
        }

        wsBackend.onmessage = {
            println("Nachricht erhalten: " + it.data)
        }


    }

    fun sendRequest(requestString:String){
        if (isConnected){
            wsBackend.send(requestString)
        }
    }

    private fun setConStatus(status:Boolean){
        isConnected = status
    }

}