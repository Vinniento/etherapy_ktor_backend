package fh_campus.routes

import fh_campus.data.controllers.UserController
import fh_campus.data.models.User
import fh_campus.data.models.Users
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.http.HttpStatusCode.Companion.InternalServerError
import io.ktor.http.HttpStatusCode.Companion.OK
import io.ktor.http.HttpStatusCode.Companion.UnprocessableEntity
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

fun Route.userRoutes() {
    route("/User") {
        get("/{personel_id}") {
            val paramId = call.parameters["personel_id"]!!.toLong()
            val user = transaction {
                UserController.getUserById(paramId)
            }
            call.respond(OK, user.toString())

        }
        post("/NewUser") {
            val userParam = try {


                call.receive<User>()
            } catch (e: java.lang.Exception) {
                call.respond(UnprocessableEntity, "Entity not parcelable")
                return@post
            }
            val item = try {

                UserController.addUser(userParam)

            } catch (e: Exception) {
                call.respond(InternalServerError, "Error in creating User -> ${e.message}")
                return@post
            }

            call.respond(OK, "UserId: ${UserController.getUserById(item)}")

        }

        post("/UpdateUser") {

        }

        post("/switchCommunication") {

        }

        get("/{user_id}/Statistics") {

        }
    }

}




