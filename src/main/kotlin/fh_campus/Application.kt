package fh_campus

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import fh_campus.plugins.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.response.*
import io.ktor.routing.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module(testing: Boolean = false) {
    // configureRouting()
    initDB()
    install(DefaultHeaders) {

    }
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
            disableHtmlEscaping()
        }
    }

    routing {
        get("/") {
            call.respondText("bladisbla")
        }
    }
}

fun initDB() {
    Database.connect(hikari())
    transaction {

        //SchemaUtils.create(Tasks)

    }

}

private fun hikari(): HikariDataSource {
    val config = HikariConfig("/hikari.properties")
    config.validate()
    return HikariDataSource(config)
}
