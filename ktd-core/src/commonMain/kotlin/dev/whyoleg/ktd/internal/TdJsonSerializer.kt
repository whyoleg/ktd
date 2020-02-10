package dev.whyoleg.ktd.internal

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.modules.*

internal class TdJsonSerializer(moduleBuilder: SerializersModuleBuilder.() -> Unit) {
    private val json = Json(jsonConfiguration, SerializersModule {
        polymorphic<TdApiRequest> {
            addSubclass(TdClose.serializer())
            addSubclass(TdDestroy.serializer())
            addSubclass(TdLogOut.serializer())
        }
        polymorphic<TdApiResponse> {
            addSubclass(TdOk.serializer())
            addSubclass(TdError.serializer())
        }
        apply(moduleBuilder)
    })

    fun parse(string: String): TdApiResponse = json.parse(responseSerializer, string)
    fun stringify(request: TdApiRequest): String = json.stringify(requestSerializer, request)

    companion object {
        private val jsonConfiguration = JsonConfiguration.Stable.copy(
            classDiscriminator = "@type",
            strictMode = false,
            encodeDefaults = false
        )
        private val responseSerializer = PolymorphicSerializer(TdApiResponse::class)
        private val requestSerializer = PolymorphicSerializer(TdRequest::class)
    }
}
