package dev.whyoleg.ktd.internal

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.modules.*

internal class TdJsonSerializer(serialModule: SerialModule) {
    private val json = Json(jsonConfiguration, serialModule + defaultTdJsonModule)

    fun parse(string: String): TdApiResponse = json.parse(responseSerializer, string)
    fun stringify(request: TdApiRequest): String = json.stringify(requestSerializer, request)
}

private val jsonConfiguration = JsonConfiguration.Stable.copy(
    classDiscriminator = "@type",
    strictMode = false,
    encodeDefaults = false
)

private val responseSerializer = PolymorphicSerializer(TdApiResponse::class)
private val requestSerializer = PolymorphicSerializer(TdRequest::class)

private val defaultTdJsonModule = SerializersModule {
    polymorphic<TdApiRequest> {
        addSubclass(TdClose.serializer())
        addSubclass(TdDestroy.serializer())
        addSubclass(TdLogOut.serializer())
    }
    polymorphic<TdApiResponse> {
        addSubclass(TdOk.serializer())
        addSubclass(TdError.serializer())
    }
}