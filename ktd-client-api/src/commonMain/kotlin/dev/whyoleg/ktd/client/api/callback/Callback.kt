package dev.whyoleg.ktd.client.api.callback

import dev.whyoleg.ktd.api.*

typealias TypedCallback<R> = (R?, TelegramError?) -> Unit
typealias Callback = TypedCallback<TelegramResponse>
