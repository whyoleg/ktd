package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a list of emoji
 *
 * @property emojis List of emojis
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("emojis")
data class TdEmojis(
    @SerialName("emojis")
    val emojis: List<String>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
