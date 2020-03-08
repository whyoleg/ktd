package dev.whyoleg.ktd.api

import kotlinx.serialization.modules.*

@Suppress("DEPRECATION_ERROR")
internal val testApiBuilder: Lazy<SerialModule> = lazy {
    coreApiBuilder.value + SerializersModule {
        polymorphic<TdApiRequest> {
            subclass(TdTestCallEmpty.serializer())
            subclass(TdTestCallString.serializer())
            subclass(TdTestCallBytes.serializer())
            subclass(TdTestCallVectorInt.serializer())
            subclass(TdTestCallVectorIntObject.serializer())
            subclass(TdTestCallVectorString.serializer())
            subclass(TdTestCallVectorStringObject.serializer())
            subclass(TdTestSquareInt.serializer())
            subclass(TdTestGetDifference.serializer())
        }
        polymorphic<TdApiResponse> {
            subclass(TdTestInt.serializer())
            subclass(TdTestString.serializer())
            subclass(TdTestBytes.serializer())
            subclass(TdTestVectorInt.serializer())
            subclass(TdTestVectorIntObject.serializer())
            subclass(TdTestVectorString.serializer())
            subclass(TdTestVectorStringObject.serializer())
        }
    }
}

