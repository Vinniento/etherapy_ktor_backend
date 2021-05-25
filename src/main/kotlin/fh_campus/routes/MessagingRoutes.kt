package fh_campus.routes

import io.ktor.routing.*


fun Route.messagingRoutes() {
    get("/{user_id}/Messages") { }

    post("/{user_id}/NewMessage") {

    }
    post("/{user_id}/UpdateMessage/{message_id}") {

    }


}