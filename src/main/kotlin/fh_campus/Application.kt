package fh_campus

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import fh_campus.data.DatabaseFactory
import fh_campus.data.models.Users
import fh_campus.routes.apiRoutes
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.routing.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import org.postgresql.Driver

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module(testing: Boolean = false) {
   //initDB()
    DatabaseFactory.init()
    install(DefaultHeaders) {

    }
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
            disableHtmlEscaping()
        }
    }

    install(Routing) {

        apiRoutes()
    }


}

fun initDB() {
    Database.connect(hikari())
    transaction {
        SchemaUtils.create(Users)
    }

}


fun hikari(): HikariDataSource {
    val config = HikariConfig("/hikari.properties")
    config.driverClassName = Driver::class.java.name
    config.validate()

    return HikariDataSource(config)
}
