package dev.whyoleg.ktd.api

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * Extra data shared between [TdRequest] and [TdResponse].
 */
@Serializable
data class TdExtra(val id: Long = 0, val data: JsonElement? = null) {
    companion object {
        val EMPTY = TdExtra()
    }
}
