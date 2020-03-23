package dev.whyoleg.ktd.client

/**
 * Platform dependent concurrent map implementation
 */
expect class ConcurrentMap<K, V>() : MutableMap<K, V>
