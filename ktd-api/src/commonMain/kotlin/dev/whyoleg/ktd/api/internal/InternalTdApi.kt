package dev.whyoleg.ktd.api.internal

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.json.*
import kotlinx.serialization.modules.*

@Deprecated(message = "Used internally inside api to init api and configure serialization", level = DeprecationLevel.ERROR)
fun InternalTdApi(
    version: String,
    requestBuilder: PolymorphicModuleBuilder<TdApiRequest>.() -> Unit,
    responseBuilder: PolymorphicModuleBuilder<TdApiResponse>.() -> Unit
): Lazy<StaticTdApi> = lazy {
    TdJson.init()
    StaticTdApi(version, TdJsonSerializer(requestBuilder, responseBuilder))
}

@Suppress("FunctionName")
private fun TdJsonSerializer(
    requestBuilder: PolymorphicModuleBuilder<TdApiRequest>.() -> Unit,
    responseBuilder: PolymorphicModuleBuilder<TdApiResponse>.() -> Unit
): TdJsonSerializer = TdJsonSerializer(SerializersModule {
    polymorphic(buildAction = requestBuilder)
    polymorphic(buildAction = responseBuilder)
})
