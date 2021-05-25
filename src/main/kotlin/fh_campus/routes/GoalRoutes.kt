package fh_campus.routes

import io.ktor.routing.*

fun Route.goalRoutes() {
    route("{user_id}/Progress") {
        get {

        }
    }
    route("{user_id}/NewGoal") {
        post { }
    }
    route("{user_id}/UpdateGoal/{goal_id}") {
        post {

        }
    }
}