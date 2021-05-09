package fh_campus

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import fh_campus.plugins.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.response.*
import io.ktor.routing.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module(testing: Boolean = false) {
   // configureRouting()

    install(DefaultHeaders) {

    }
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
            disableHtmlEscaping()
        }
    }

    routing {
        get("/"){
            call.respondText("bladibla")
        }
    }
}
