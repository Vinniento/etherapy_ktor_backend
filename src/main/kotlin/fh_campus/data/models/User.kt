package fh_campus.data.models

import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table

object Users : Table() {
    val userId = long("userId").autoIncrement().primaryKey()
    val firstname = text("firstname")
    val lastname = text("lastname")

    // 1 is patient, 2 is therapist, 3 is super admin
    val role = integer("role").default(1)

    //code for therapist users to enable therapist mode
    val code = text("code")

    // track # of password resets
    val passwordResets = integer("password_resets")

    fun toUser(row: ResultRow): User = User(
        userId = row[userId],
        firstname = row[firstname],
        lastname = row[lastname],
        role = row[role],
        code = row[code],
        passwordResets = row[passwordResets]
    )
}

data class User(
    val userId: Long = 0,
    val firstname: String,
    val lastname: String,
    val role: Int = 1,
    val code: String,
    val passwordResets: Int = 0
) {
    override fun toString(): String {
        return "$userId $firstname $lastname"
    }
}