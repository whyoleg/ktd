package dev.whyoleg.ktd

import dev.whyoleg.ktd.api.*

inline class TdResult<T : TdResponse>(private val responseOrError: TdResponseOrError) {
    @Suppress("UNCHECKED_CAST")
    val response: T?
        get() = responseOrError as? T
    val error: TdError?
        get() = responseOrError as? TdError

    inline fun <R> handle(onResponse: T.() -> R, onError: TdError.() -> R): R {
        response?.let { return onResponse(it) }
        error?.let { return onError(it) }
        error("Cast failed!")
    }
}
