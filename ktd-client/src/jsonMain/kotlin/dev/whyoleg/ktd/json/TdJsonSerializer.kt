package dev.whyoleg.ktd.json

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlin.reflect.*
import kotlin.collections.*

interface JsonSerializer<T : TdObject> {
    val type: String
    val cls: KClass<T>
    val JsonObject.value: T
    fun JsonObjectBuilder.put(value: T)
}

@OptIn(UnstableDefault::class)
class TdJsonSerializer internal constructor(
    updates: List<JsonSerializer<out TdUpdate>>,
    responses: List<JsonSerializer<out TdResponse>>,
    requests: List<JsonSerializer<out TdApiRequest>>
) {
    private val error: JsonSerializer<TdError> = TODO()
    private val updates = updates.associateByTo(HashMap(updates.size), JsonSerializer<*>::type)
    private val responses = responses.associateByTo(HashMap(responses.size), JsonSerializer<*>::type)
    private val requests = requests.associateByTo(HashMap(requests.size), JsonSerializer<*>::cls)

    fun result(value: String): TdResult = deserialize(value) { type, json ->
        when (val id = json.getValue("@extra").long) {
            0L -> updates.getValue(type).run { TdResult.Update(json.value) }
            else -> handle(type, json, {
                TdResult.ResponseOrError.Error(id, it)
            }, {
                TdResult.ResponseOrError.Response(id, it)
            })
        }
    }

    fun <T : TdResponse> executeResult(value: String): TdTypedResult<T> = deserialize(value) { type, json ->
        handle(type, json, {
            TdTypedResult.Error(it)
        }, {
            TdTypedResult.Response(@Suppress("UNCHECKED_CAST") (it as T))
        })
    }

    fun request(id: Long, value: TdApiRequest): String = serialize(value) { "@extra" to id }

    fun executeRequest(value: TdApiRequest): String = serialize(value)

    private inline fun <T> handle(type: String, json: JsonObject, onError: (TdError) -> T, onResponse: (TdResponse) -> T): T = when (type) {
        "error" -> error.run { onError(json.value) }
        else    -> responses.getValue(type).run { onResponse(json.value) }
    }

    private inline fun <T> deserialize(value: String, block: (type: String, json: JsonObject) -> T): T {
        val json = Json.parse(JsonObjectSerializer, value)
        val type = json.getValue("@type").content
        return block(type, json)
    }

    private inline fun serialize(value: TdApiRequest, crossinline block: JsonObjectBuilder.() -> Unit = {}): String = json {
        with(@Suppress("UNCHECKED_CAST") (requests.getValue(value::class) as JsonSerializer<TdApiRequest>)) {
            put(value)
            "@type" to type
        }
        block()
    }.toString()

}
