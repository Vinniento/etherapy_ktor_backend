package fh_campus.data.controllers

import fh_campus.data.models.User
import fh_campus.data.models.Users
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.insertIgnore
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

object UserController {

    fun addUser(user: User): Long = transaction {
        if (Users.select { Users.userId eq user.userId }.toList().isEmpty())
            Users.insert {
                it[firstname] = user.firstname
                it[lastname] = user.lastname
                it[role] = user.role
                it[code] = user.code
                it[passwordResets] = user.passwordResets
            }[Users.userId]
        else
            updateUser(user)
    }

    private fun updateUser(user: User): Long = transaction {
        Users.insertIgnore {
            it[userId] = user.userId
            it[firstname] = user.firstname
            it[lastname] = user.lastname
            it[role] = user.role
            it[code] = user.code
            it[passwordResets] = user.passwordResets
        }[Users.userId]
    }

    fun getUserById(id: Long): User? = transaction {
        try {

            Users.select { Users.userId eq id }.map(Users::toUser).single()
        } catch (e: Exception) {
            null
        }
    }
}


