package dev.whyoleg.ktd.test

expect class BlockingQueue<E>() {
    fun offer(element: E)
    fun poll(seconds: Double): E?
}
