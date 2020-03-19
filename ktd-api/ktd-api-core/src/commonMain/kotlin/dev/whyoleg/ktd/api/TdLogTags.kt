package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains a list of available TDLib internal log tags
 *
 * @property tags List of log tags
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("logTags")
data class TdLogTags(
    @SerialName("tags")
    val tags: List<String>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
