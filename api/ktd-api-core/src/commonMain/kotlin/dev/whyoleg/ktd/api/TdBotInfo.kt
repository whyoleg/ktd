package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Provides information about a bot and its supported commands
 *
 * @property description Long description shown on the user info page
 * @property commands A list of commands supported by the bot
 */
@Serializable
@SerialName("botInfo")
data class TdBotInfo(
    @SerialName("description")
    val description: String,
    @SerialName("commands")
    val commands: List<TdBotCommand>
) : TdObject
