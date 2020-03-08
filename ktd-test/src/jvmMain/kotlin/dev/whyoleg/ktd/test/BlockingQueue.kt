package dev.whyoleg.ktd.test

import java.util.concurrent.*

actual class BlockingQueue<E> {
    private val queue = LinkedBlockingQueue<E>()
    actual fun offer(element: E) {
        queue.offer(element)
    }

    actual fun poll(seconds: Double): E? = queue.poll(seconds.toLong(), TimeUnit.SECONDS)
}
