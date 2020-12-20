package dev.whyoleg.ktd

import java.util.concurrent.*
import kotlin.concurrent.*

internal actual fun <K, V> concurrentMap(): MutableMap<K, V> = ConcurrentHashMap()

internal actual fun runInThread(block: () -> Boolean) {
    thread { while (block()) Unit }
}
