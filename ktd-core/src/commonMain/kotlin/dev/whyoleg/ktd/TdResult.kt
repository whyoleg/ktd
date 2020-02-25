package dev.whyoleg.ktd

import dev.whyoleg.ktd.api.*

inline class TdResult<T : TdResponse>(private val responseOrError: TdResponseOrError) {
    @Suppress("UNCHECKED_CAST")
    val response: T?
        get() = responseOrError as? T
    val error: TdError?
        get() = responseOrError as? TdError

    inline fun handle(onResponse: T.() -> Unit, onError: TdError.() -> Unit) {
        response?.let(onResponse) ?: error?.let(onError)
    }
}
