package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents commands supported by a bot
 *
 * @property command Text of the bot command
 * @property description Description of the bot command
 */
@Serializable
@SerialName("botCommand")
data class TdBotCommand(
    @SerialName("command")
    val command: String,
    @SerialName("description")
    val description: String
) : TdObject
