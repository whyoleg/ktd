package dev.whyoleg.ktd.cli.tdlib

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.response.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.util.*
import kotlinx.cli.*
import kotlinx.coroutines.*
import kotlinx.serialization.json.*
import java.util.*

@UseExperimental(ExperimentalCli::class)
class DispatchCommand : Subcommand("dispatch") {
    private val version by option(ArgType.String, "version", "v", "Version of tdlib").required()
    private val type by option(ArgType.Choice(listOf("api", "tdlib")), "type", "t", "Type of event").required()

    @UseExperimental(KtorExperimentalAPI::class)
    override fun execute() {
        val client = HttpClient(CIO)
        runBlocking {
            val response = client.post<HttpResponse>("https://api.github.com/repos/whyoleg/ktd/dispatches") {
                val toke = ""
                headers["Accept"] = "application/vnd.github.everest-preview+json"
                headers["Authorization"] = "Basic " + Base64.getEncoder().encodeToString("whyoleg:$toke".toByteArray())
                body = TextContent(json {
                    "event_type" to "generate_$type"
                    "client_payload" to json {
                        "version" to version
                    }
                }.toString(), ContentType.Application.Json)
            }
            println(response)
            println(response.status)
        }
    }
}
