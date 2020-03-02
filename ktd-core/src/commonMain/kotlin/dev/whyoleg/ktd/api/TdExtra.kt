package dev.whyoleg.ktd.api

import dev.whyoleg.ktd.json.*
import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * Extra data shared between [TdRequest] and [TdResponse].
 */
@Serializable
data class TdExtra(val id: Long = 0, @ExperimentalTdInterface val data: JsonElement? = null) {
    companion object {
        val EMPTY = TdExtra()
    }
}
