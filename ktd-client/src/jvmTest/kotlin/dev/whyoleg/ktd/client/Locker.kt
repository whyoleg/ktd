package dev.whyoleg.ktd.client

import kotlinx.atomicfu.*

class Locker {
    private val atomic = atomic(3)
    private val lock = atomic(false)

    val isLocked get() = lock.value
    val atomicValue get() = atomic.value
    fun lock() {
        lock.value = true
    }

    fun unlock() {
        lock.value = false
    }

    fun checkAtomic() = atomic.decrementAndGet() != 0
}