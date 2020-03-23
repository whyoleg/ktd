package dev.whyoleg.ktd.client

/**
 * Platform dependent synchronized runner. Used by default
 */
@Suppress("FunctionName")
expect fun DefaultSynchronizedRunner(): SynchronizedRunner
