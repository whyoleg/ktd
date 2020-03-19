package dev.whyoleg.ktd.client

import kotlinx.atomicfu.*

class Locker(init: Int = 3) {
    private val _counter = atomic(init)
    private val lock = atomic(false)

    val isLocked get() = lock.value
    val counter get() = _counter.value
    fun lock() {
        lock.value = true
    }

    fun unlock() {
        lock.value = false
    }

    fun decrementAndCheck() = _counter.decrementAndGet() != 0
}
