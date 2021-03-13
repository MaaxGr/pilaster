package com.pilaster.frontend.handler

import com.pilaster.frontend.components.state.AppState
import com.pilaster.frontend.components.state.BackendState
import com.pilaster.frontend.store
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.w3c.dom.WebSocket
import kotlin.coroutines.CoroutineContext

object ConnHandler : CoroutineScope{

    private var isConnected:Boolean = false
    private val job = Job()

    //TODO: Umstellen auf SSL (wss://)
    private val protocol = "ws://"
    private val url ="localhost:8448/WS"

    private lateinit var wsBackend : WebSocket

    init {
        launch{
            connectionLoop()
        }
    }

    fun connectToBackend(){
        wsBackend = WebSocket(protocol + url)

        wsBackend.onopen ={
            println("Websocket geöffnet")
            setConStatus(true)
            store.state.backend.isConnected = true
            store.dispatch("Dummy")
        }

        wsBackend.onclose = {
            println("Websocket geschlossen")
            setConStatus(false)
            store.state.backend.isConnected = false
            store.dispatch("Dummy")
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

    private suspend fun connectionLoop(){
        while (true) {
            if (!isConnected) {
                connectToBackend()
            }
            delay(10000)
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job

}