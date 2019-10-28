package dev.whyoleg.ktd

import dev.whyoleg.ktd.api.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class TelegramClient internal constructor(private val actor: TelegramClientActor, job: Job) : Job by job {
    public val updates: Flow<TelegramUpdate> = actor.updatesChannel.flow
    public fun send(function: TelegramFunction): Unit = actor.ignore(function)
    public suspend fun exec(function: TelegramFunction): TelegramObject = actor.await(function)
}
