package dev.whyoleg.ktd.client

@Suppress("FunctionName")
actual fun DefaultSynchronizedRunner(): SynchronizedRunner = DistinctThreadRunner()
