package dev.whyoleg.ktd.client.api

actual val DefaultSynchronizedRunner: SynchronizedRunner get() = SingleThreadRunner

actual fun <T : Any> DefaultResponseHandlerStorage(): ResponseHandlerStorage<T> = ConcurrentMapStorage()