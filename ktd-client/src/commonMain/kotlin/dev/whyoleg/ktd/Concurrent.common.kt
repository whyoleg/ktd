package dev.whyoleg.ktd

internal expect fun runInThread(block: () -> Boolean)

internal expect fun <K, V> concurrentMap(): MutableMap<K, V>
