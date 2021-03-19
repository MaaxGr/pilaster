package com.pilaster.frontend.handler

import com.pilaster.common.CommHead
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
    private var job_active: Boolean = false

    //TODO: Umstellen auf SSL (wss://)
    private val protocol = "ws://"
    private val url ="localhost:8448/WS"

    val anfragen = mutableListOf<CommHead>()
    val antworten = mutableListOf<CommHead>()

    private lateinit var wsBackend : WebSocket

    init {
        launch{
            connectionLoop()
        }
    }

    fun dummy():String{
        return "Dummy"
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

            launch{
                connectionLoop()
            }
        }

        wsBackend.onmessage = {
            println("Nachricht erhalten: " + it.data)
            try {

                val result = JSON.parse<CommHead>(it.data.toString())
                antworten.add(result)
            } catch (ex:Exception){
                console.log(ex.message)
            }



        }


    }

    fun sendRequest(request:CommHead){
        if (isConnected){
            anfragen.add(request)
            wsBackend.send(JSON.stringify(request))
        }
    }

    private fun setConStatus(status:Boolean){
        isConnected = status
    }

    private suspend fun connectionLoop(){
        if (job_active){
            return
        } else {
            job_active = true
        }
        while (!isConnected) {
            connectToBackend()
            delay(3000)
        }
        job_active = false
    }

    override val coroutineContext: CoroutineContext
        get() = job

}