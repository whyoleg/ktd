package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.api.*

typealias TypedTdCallback<R> = TdResult<R>.() -> Unit

typealias TdCallback = TypedTdCallback<TdResponse>

typealias TdUpdatesCallback = (TdUpdate) -> Unit
