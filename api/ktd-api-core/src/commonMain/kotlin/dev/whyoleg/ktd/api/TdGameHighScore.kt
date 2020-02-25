package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains one row of the game high score table
 *
 * @property position Position in the high score table
 * @property userId User identifier
 * @property score User score
 */
@Serializable
@SerialName("gameHighScore")
data class TdGameHighScore(
    @SerialName("position")
    val position: Int,
    @SerialName("user_id")
    val userId: Int,
    @SerialName("score")
    val score: Int
) : TdObject
