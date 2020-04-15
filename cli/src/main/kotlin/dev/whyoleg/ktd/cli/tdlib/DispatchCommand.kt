package dev.whyoleg.ktd.cli.tdlib

import dev.whyoleg.ktd.cli.*
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.util.*
import kotlinx.cli.*
import kotlinx.coroutines.*
import kotlinx.serialization.json.*
import java.util.*

@OptIn(ExperimentalCli::class)
class DispatchCommand : Subcommand("dispatch", "Dispatch GH action") {
    private val version by option(ArgType.String, "version", "v", "Version of TdLib").required()
    private val type by option(DispatchTypeArgType, "type", "t", "Type of dispatch").required()

    @OptIn(KtorExperimentalAPI::class)
    override fun execute() {
        val client = HttpClient(CIO)
        runBlocking {
            val response = client.post<HttpResponse>("https://api.github.com/repos/whyoleg/ktd/dispatches") {
                val token = System.getenv("GITHUB_ACCESS_TOKEN")!!
                headers["Accept"] = "application/vnd.github.everest-preview+json"
                headers["Authorization"] = "Basic " + Base64.getEncoder().encodeToString("whyoleg:$token".toByteArray())
                body = TextContent(json {
                    "event_type" to type.name
                    "client_payload" to buildPayload(type)
                }.toString(), ContentType.Application.Json)
            }
            println(response.status)
        }
    }

    fun buildPayload(type: DispatchType): JsonObject = when (type) {
        DispatchType.BuildTdlib          -> json {
            "lib_version" to "2"
            "version" to version
            "ref" to tdVersionRefs.getValue(version)
        }
        DispatchType.RunBenchmarks       -> json {
            "version" to version
        }
        DispatchType.RunIntegrationTests -> json {}
        DispatchType.Release             -> TODO()
    }
}

enum class DispatchType {
    BuildTdlib,
    RunBenchmarks,
    RunIntegrationTests,
    Release
}

object DispatchTypeArgType : ArgType<DispatchType>(true) {
    override val description: kotlin.String = "{ DispatchType }"
    override fun convert(value: kotlin.String, name: kotlin.String): DispatchType =
        DispatchType.values().find { it.name.contains(value, ignoreCase = true) } ?: error("Dispatch '$value' isn't supported")
}
