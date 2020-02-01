package dev.whyoleg.ktd.api.internal

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.json.*
import kotlinx.serialization.modules.*

@Deprecated(message = "Used internally inside api to init api and configure serialization", level = DeprecationLevel.ERROR)
fun InternalTelegramApi(
    version: String,
    requestBuilder: PolymorphicModuleBuilder<TelegramApiRequest>.() -> Unit,
    responseBuilder: PolymorphicModuleBuilder<TelegramApiResponse>.() -> Unit
): TelegramApi {
    TelegramJson.init()
    return TelegramApi(version, TelegramJsonSerializer(requestBuilder, responseBuilder))
}

@Suppress("FunctionName")
internal fun TelegramJsonSerializer(
    requestBuilder: PolymorphicModuleBuilder<TelegramApiRequest>.() -> Unit,
    responseBuilder: PolymorphicModuleBuilder<TelegramApiResponse>.() -> Unit
): TelegramJsonSerializer = TelegramJsonSerializer(SerializersModule {
    polymorphic(buildAction = requestBuilder)
    polymorphic(buildAction = responseBuilder)
})
