package fh_campus.routes

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.http.HttpStatusCode.Companion.OK
import io.ktor.response.*
import io.ktor.routing.*

fun Route.personelRoutes() {

    get {
        call.respondText("blaaaa")
    }
    post("/login") {
        call.respond(OK)
    }

    post("/logout") {

    }
}