package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains a list of game high scores
 *
 * @property scores A list of game high scores
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("gameHighScores")
data class TdGameHighScores(
    @SerialName("scores")
    val scores: List<TdGameHighScore>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
