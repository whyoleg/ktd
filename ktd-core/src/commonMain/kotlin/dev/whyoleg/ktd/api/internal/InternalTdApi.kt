package dev.whyoleg.ktd.api.internal

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.json.*
import kotlinx.serialization.modules.*

@Suppress("FunctionName")
@Deprecated(message = "Used internally inside api to init api and configure serialization", level = DeprecationLevel.ERROR)
fun InternalTdApi(
    version: String,
    builder: SerializersModuleBuilder.() -> Unit
): Lazy<StaticTdApi> = lazy {
    TdJson.init()
    StaticTdApi(version, TdJsonSerializer(SerializersModule {
        polymorphic<TdApiRequest> {
            addSubclass(TdClose.serializer())
            addSubclass(TdDestroy.serializer())
            addSubclass(TdLogOut.serializer())
        }
        polymorphic<TdApiResponse> {
            addSubclass(TdOk.serializer())
            addSubclass(TdError.serializer())
        }
        apply(builder)
    }))
}