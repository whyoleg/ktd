package dev.whyoleg.ktd

import dev.whyoleg.ktd.api.*
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.flow.*

private sealed class Action {
    data class Handler(val id: Long, val deferred: CompletableDeferred<TelegramObject>) : Action()
    data class Event(val id: Long, val event: TelegramObject) : Action()
    data class Ignore(val id: Long) : Action()
}

private inline fun launchOnSingleThread(job: Job, clientId: Long, crossinline block: () -> Unit) {
    val singleThread = newSingleThreadContext("TelegramClient[$clientId]")
    CoroutineScope(singleThread + job)
        .launch { while (isActive) block() }
        .invokeOnCompletion { singleThread.close() }
}

private fun CompletableDeferred<TelegramObject>.completeWith(obj: TelegramObject): Boolean = when (obj) {
    is TelegramError -> completeExceptionally(TelegramException(obj.code, obj.message))
    else             -> complete(obj)
}

private fun handle(job: Job, channel: ReceiveChannel<Action>) {
    CoroutineScope(Dispatchers.Default + job).launch {
        val eventHandlers = mutableMapOf<Long, CompletableDeferred<TelegramObject>>()
        val eventResults = mutableMapOf<Long, TelegramObject>()
        val ignoredEvents = mutableSetOf<Long>()
        channel.consumeEach {
            when (it) {
                is Action.Ignore  -> if (eventResults.remove(it.id) == null) ignoredEvents += it.id
                is Action.Handler -> when (val event = eventResults.remove(it.id)) {
                    null -> eventHandlers[it.id] = it.deferred
                    else -> it.deferred.completeWith(event)
                }
                is Action.Event   -> if (!ignoredEvents.remove(it.id)) when (val handler = eventHandlers.remove(it.id)) {
                    null -> eventResults[it.id] = it.event
                    else -> handler.completeWith(it.event)
                }
            }
        }
    }
}

internal class TelegramClientActor(private val nativeClient: NativeClient, job: Job) : TelegramClient, Job by job {
    private val channel = Channel<Action>(Channel.UNLIMITED)
    private val updatesChannel = UpdatesChannel(this)
    private val functionsJob = SupervisorJob(this)
    override val updates: Flow<TelegramUpdate> = updatesChannel.flow

    init {
        launchOnSingleThread(this, nativeClient.clientId) { nativeClient.receive(this::handle) }
        handle(this, channel)
    }

    private fun handle(eventId: Long, obj: TelegramObject) {
        when (obj) {
            is TelegramUpdate -> updatesChannel.offer(obj)
            else              -> channel.offer(Action.Event(eventId, obj))
        }
    }

    override suspend fun exec(function: TelegramFunction): TelegramObject {
        val eventId = nativeClient.send(function)
        val deferred = CompletableDeferred<TelegramObject>(functionsJob)
        channel.offer(Action.Handler(eventId, deferred))
        return deferred.await()
    }

    override fun send(function: TelegramFunction) {
        val eventId = nativeClient.send(function)
        channel.offer(Action.Ignore(eventId))
    }
}
