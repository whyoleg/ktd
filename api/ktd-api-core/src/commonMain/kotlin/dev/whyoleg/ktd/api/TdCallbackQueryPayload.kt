package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a payload of a callback query
 */
@Serializable
sealed class TdCallbackQueryPayload : TdObject {
    /**
     * The payload from a general callback button
     *
     * @property data Data that was attached to the callback button
     */
    @Serializable
    @SerialName("callbackQueryPayloadData")
    data class Data(
        @SerialName("data")
        val data: ByteArray
    ) : TdCallbackQueryPayload()

    /**
     * The payload from a game callback button
     *
     * @property gameShortName A short name of the game that was attached to the callback button
     */
    @Serializable
    @SerialName("callbackQueryPayloadGame")
    data class Game(
        @SerialName("game_short_name")
        val gameShortName: String
    ) : TdCallbackQueryPayload()
}
