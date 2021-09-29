import io.ktor.application.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.html.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
        routing {

            get("/") {
                val file = this::class.java.classLoader.getResource("index.html")
                call.respondText(
                    file!!.readText(),
                    ContentType.Text.Html
                )
            }

            static("/") {
                resources("")
            }
        }
    }.start(wait = true)
}