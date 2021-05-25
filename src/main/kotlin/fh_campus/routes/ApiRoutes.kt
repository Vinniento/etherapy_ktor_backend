package fh_campus.routes

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.apiRoutes() {

        userRoutes()
    route("/Goals") {
        goalRoutes()
    }
    route("/Messaging") {
        messagingRoutes()
    }
    route("/personel") {
        personelRoutes()
    }
}