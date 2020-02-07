package dev.whyoleg.ktd.api.internal

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.modules.*

internal class TdJsonSerializer(module: SerialModule) {
    private val json = Json(jsonConfiguration, module)

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
