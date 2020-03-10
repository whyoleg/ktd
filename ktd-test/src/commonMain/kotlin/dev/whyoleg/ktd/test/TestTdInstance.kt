package dev.whyoleg.ktd.test

import dev.whyoleg.ktd.api.*

interface TestTdInstance {
    fun send(request: TdApiRequest): Unit = Unit
    fun receive(timeout: Double): TdApiResponse? = null
}

object EmptyTestTdInstance : TestTdInstance
