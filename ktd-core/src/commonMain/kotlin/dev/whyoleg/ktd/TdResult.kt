package dev.whyoleg.ktd

import dev.whyoleg.ktd.api.*

/**
 * Result of request to [TdApi] synchronous or via callback in client
 */
inline class TdResult<T : TdResponse>(private val responseOrError: TdResponseOrError) {

    /**
     * Typed [TdResponse] or null if contains [TdError]
     */
    @Suppress("UNCHECKED_CAST")
    val response: T?
        get() = responseOrError as? T

    /**
     * [TdError] or null if [TdResponse] exists
     */
    val error: TdError?
        get() = responseOrError as? TdError

    /**
     * Used to handle result
     *
     * @param onResponse called when contains successful [TdResponse]
     * @param onError called when contains [TdError]
     */
    inline fun <R> handle(onResponse: T.() -> R, onError: TdError.() -> R): R {
        response?.let { return onResponse(it) }
        error?.let { return onError(it) }
        error("") //never happens
    }
}
