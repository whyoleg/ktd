package dev.whyoleg.ktd.api

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * Represents [TdRequest] or [TdResponse] which contains extra data.
 */
interface TdPayload : TdObject {
    val extra: TdExtra
}

/**
 * Extra data shared between [TdRequest] and [TdResponse].
 */
@Serializable
data class TdExtra(val id: Long = 0, val data: JsonElement? = null) {
    companion object {
        val EMPTY = TdExtra()
    }
}
