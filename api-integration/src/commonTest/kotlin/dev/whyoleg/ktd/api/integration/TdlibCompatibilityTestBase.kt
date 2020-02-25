package dev.whyoleg.ktd.api.integration

import dev.whyoleg.ktd.api.*
import kotlin.test.*

abstract class TdlibCompatibilityTestBase {

    @Test
    fun executeFunction() {
        val logLevel = 11
        TestTdApi.executeSynchronously(TdSetLogVerbosityLevel(logLevel))
        val newLevel = TestTdApi.executeSynchronously(TdGetLogVerbosityLevel()).response!!.verbosityLevel
        assertEquals(logLevel, newLevel)
        TestTdApi.executeSynchronously(TdSetLogVerbosityLevel(0))
    }

    @Test
    fun createClient() {
        val clientId = TestTdApi.createClient()
        val clientId2 = TestTdApi.createClient()
        assertNotEquals(clientId, clientId2)
        TestTdApi.destroyClient(clientId)
        TestTdApi.destroyClient(clientId2)
    }

    @Test
    fun receiveUpdates() {
        val clientId = TestTdApi.createClient()
        val received = TestTdApi.receiveFrom(clientId)
        assertNotNull(received)
    }

    @Test
    fun sendObject() {
        val clientId = TestTdApi.createClient()
        TestTdApi.sendTo(clientId, TdTestCallEmpty(TdExtra(1)))
        var ok: TdOk?
        do {
            ok = TestTdApi.receiveFrom(clientId) as? TdOk
        } while (ok == null)
    }

}
