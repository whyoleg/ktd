package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.api.*
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.sync.*
import kotlin.math.*

@OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class, InternalCoroutinesApi::class, ExperimentalStdlibApi::class)
internal class UpdatesFlow(private val cacheSize: Int, job: Job) : AbstractFlow<TdUpdate>() {
    private val mutex = Mutex()
    private val cache = ArrayDeque<TdUpdate>()
    private val channels = mutableSetOf<SendChannel<TdUpdate>>()
    private val scope = CoroutineScope(job + Dispatchers.Default)
    private val updatesChannel = Channel<TdUpdate>(Channel.UNLIMITED)

    init {
        scope.launch {
            updatesChannel.consumeEach {
                mutex.withLock {
                    if (cache.size >= cacheSize) cache.removeFirstOrNull()
                    cache.addLast(it)

                    channels.forEach { channel ->
                        channel.runCatching { offer(it) }
                    }
                }
            }
        }.invokeOnCompletion { error ->
            GlobalScope.launch {
                mutex.withLock {
                    channels.forEach { channel -> channel.close(error) }
                    channels.clear()
                    cache.clear()
                }
            }
        }
    }

    fun emit(update: TdUpdate) {
        updatesChannel.offer(update)
    }

    override suspend fun collectSafely(collector: FlowCollector<TdUpdate>) {
        scope.ensureActive()
        val channel = Channel<TdUpdate>(Channel.UNLIMITED)
        try {
            val values = mutex.withLock {
                channels += channel
                ArrayDeque(cache)
            }
            scope.ensureActive()
            while (when (val element = values.removeFirstOrNull()) {
                    null -> false
                    else -> {
                        collector.emit(element)
                        true
                    }
                }
            ) Unit
            collector.emitAll(channel)
        } catch (e: Throwable) {
            scope.launch {
                mutex.withLock {
                    channels -= channel
                }
            }
            throw e
        }
    }
}
