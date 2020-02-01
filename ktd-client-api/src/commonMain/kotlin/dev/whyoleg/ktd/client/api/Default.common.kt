package dev.whyoleg.ktd.client.api

expect val DefaultSynchronizedRunner: SynchronizedRunner

expect fun <T : Any> DefaultResponseHandlerStorage(): ResponseHandlerStorage<T>