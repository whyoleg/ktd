package dev.whyoleg.ktd.client.api

import dev.whyoleg.ktd.api.*

interface UpdatesManager<Updates : Any> {
    val updates: Updates
    fun handle(update: TelegramUpdate)
}

interface UnitUpdatesManager : UpdatesManager<Unit> {
    override val updates: Unit get() = Unit
}
