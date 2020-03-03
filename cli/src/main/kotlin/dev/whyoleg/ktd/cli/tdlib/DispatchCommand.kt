package dev.whyoleg.ktd.cli.tdlib

import dev.whyoleg.ktd.cli.*
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

@OptIn(ExperimentalCli::class)
class DispatchCommand : Subcommand("dispatch") {
    private val version by option(ArgType.String, "version", "v", "Version of TdLib").required()
    private val type by option(ArgType.Choice(listOf("api", "tdlib")), "type", "t", "Type of event").required()

    @OptIn(KtorExperimentalAPI::class)
    override fun execute() {
        val client = HttpClient(CIO)
        runBlocking {
            val response = client.post<HttpResponse>("https://api.github.com/repos/whyoleg/ktd/dispatches") {
                val token = System.getenv("GITHUB_ACCESS_TOKEN")!!
                headers["Accept"] = "application/vnd.github.everest-preview+json"
                headers["Authorization"] = "Basic " + Base64.getEncoder().encodeToString("whyoleg:$token".toByteArray())
                body = TextContent(json {
                    "event_type" to "generate_$type"
                    "client_payload" to json {
                        "lib_version" to "2"
                        "version" to version
                        "ref" to tdVersionRefs.getValue(version)
                        "versions" to jsonArray {
                            tdVersions.forEach { +it }
                        }
                        "refs" to json {
                            tdVersionRefs.forEach { (v, ref) -> v to ref }
                        }
                    }
                }.toString(), ContentType.Application.Json)
            }
            println(response)
            println(response.status)
        }
    }
}
