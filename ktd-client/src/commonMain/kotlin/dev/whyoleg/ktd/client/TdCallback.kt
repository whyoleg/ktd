package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.api.*

/**
 * Callback to handle [TdResult] from [TdClient]
 */
typealias TypedTdCallback<R> = (result: TdTypedResult<R>) -> Unit

/**
 * Callback to handle [TdUpdate] from [TdClient]
 */
typealias TdUpdatesCallback = (TdUpdate) -> Unit

/**
 * Untyped callback for internal use
 */
internal typealias TdCallback = TypedTdCallback<TdResponse>
