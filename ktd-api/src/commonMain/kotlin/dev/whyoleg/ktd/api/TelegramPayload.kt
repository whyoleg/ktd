package dev.whyoleg.ktd.api

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * Represents [TelegramRequest] or [TelegramResponse] which contains extra data.
 */
interface TelegramPayload : TelegramObject {
    val extra: TelegramExtra
}

/**
 * Extra data shared between [TelegramRequest] and [TelegramResponse].
 */
@Serializable
data class TelegramExtra(val id: Long = 0, val data: JsonElement? = null)
