package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes a game
 *
 * @property id Game ID
 * @property shortName Game short name
 *                     To share a game use the URL https://t.me/{bot_username}?game={game_short_name}
 * @property title Game title
 * @property text Game text, usually containing scoreboards for a game
 * @property description Game description
 * @property photo Game photo
 * @property animation Game animation
 */
@Serializable
@SerialName("game")
data class TdGame(
    @SerialName("id")
    val id: Long,
    @SerialName("short_name")
    val shortName: String,
    @SerialName("title")
    val title: String,
    @SerialName("text")
    val text: TdFormattedText,
    @SerialName("description")
    val description: String,
    @SerialName("photo")
    val photo: TdPhoto,
    @SerialName("animation")
    val animation: TdAnimation?
) : TdObject
