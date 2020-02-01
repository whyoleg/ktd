package dev.whyoleg.ktd.client.api.callback

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.api.*

typealias UpdatesCallback = (TelegramUpdate) -> Unit

class CallbackUpdatesManager(private val callback: UpdatesCallback) : UnitUpdatesManager {
    override fun handle(update: TelegramUpdate) {
        callback(update)
    }
}
