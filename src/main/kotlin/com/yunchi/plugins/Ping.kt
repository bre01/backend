package com.yunchi.plugins

import com.yunchi.Config
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.plugins.openapi.*
import java.nio.file.Files
import java.nio.file.Path.of

fun Application.configurePing() {
    routing {
        get("/ping") {
            call.respond(HttpStatusCode.OK)
        }
        openAPI("/api", swaggerFile = Config.resource + "api.json")
        get("/api-group"){
            call.respondText(Files.readString(
                of(
                    Config.resource + "api-group.html"
                )
            ), ContentType.parse("text/html"))
        }
    }
}
