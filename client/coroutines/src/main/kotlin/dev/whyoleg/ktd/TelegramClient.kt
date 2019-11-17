package dev.whyoleg.ktd

import dev.whyoleg.ktd.api.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

interface TelegramClient : Job {
    val updates: Flow<TelegramUpdate>
    fun send(function: TelegramFunction)
    suspend fun exec(function: TelegramFunction): TelegramObject

    companion object {
        fun exec(function: TelegramFunction): TelegramObject = TdClient.execute(function)
    }
}
