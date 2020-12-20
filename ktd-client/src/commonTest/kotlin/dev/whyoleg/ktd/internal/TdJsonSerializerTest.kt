package dev.whyoleg.ktd.internal

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.binding.*
import kotlinx.serialization.json.*
import kotlinx.serialization.modules.*
import kotlin.test.*

internal class TdJsonSerializerTest {
    private val serializer = TdJsonSerializer(EmptyModule)

    @Test
    fun checkBuiltInRequests() {
        serializer.stringify(TdClose())
        serializer.stringify(TdDestroy())
        serializer.stringify(TdLogOut())
    }

    @Test
    fun checkCloseRequest() {
        val close = serializer.stringify(TdClose())
        val json = Json(context = EmptyModule).parseJson(close).jsonObject
        assertEquals("close", json["@type"]?.content)
    }

    @Test
    fun checkCloseExtraRequest() {
        val close = serializer.stringify(TdClose(extra = TdExtra(id = 3)))
        val json = Json(context = EmptyModule).parseJson(close).jsonObject
        assertEquals("close", json["@type"]!!.content)
        assertEquals(3, json["@extra"]!!.jsonObject["id"]!!.long)
    }

    @Test
    fun checkOkResponse() {
        assertTrue(serializer.parse("""{@type: "ok"}""") is TdOk)
    }

    @Test
    fun checkExtraInOkResponse() {
        val response = serializer.parse("""{@type: "ok", @extra: {id: 1}}""")
        assertTrue(response is TdOk)
        assertEquals(1, response.extra.id)
    }

    @Test
    fun checkFailWithoutTypeResponse() {
        assertFails { serializer.parse("""{v: "ok"}""") }
    }
}
