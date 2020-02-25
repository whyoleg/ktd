package dev.whyoleg.ktd.api

import kotlinx.serialization.modules.*

@Suppress("DEPRECATION_ERROR")
internal val testApiBuilder: Lazy<SerialModule> = lazy {
    coreApiBuilder.value + SerializersModule {
        polymorphic<TdApiRequest> {
            addSubclass(TdTestCallEmpty.serializer())
            addSubclass(TdTestCallString.serializer())
            addSubclass(TdTestCallBytes.serializer())
            addSubclass(TdTestCallVectorInt.serializer())
            addSubclass(TdTestCallVectorIntObject.serializer())
            addSubclass(TdTestCallVectorString.serializer())
            addSubclass(TdTestCallVectorStringObject.serializer())
            addSubclass(TdTestSquareInt.serializer())
            addSubclass(TdTestGetDifference.serializer())
        }
        polymorphic<TdApiResponse> {
            addSubclass(TdTestInt.serializer())
            addSubclass(TdTestString.serializer())
            addSubclass(TdTestBytes.serializer())
            addSubclass(TdTestVectorInt.serializer())
            addSubclass(TdTestVectorIntObject.serializer())
            addSubclass(TdTestVectorString.serializer())
            addSubclass(TdTestVectorStringObject.serializer())
        }
    }
}

