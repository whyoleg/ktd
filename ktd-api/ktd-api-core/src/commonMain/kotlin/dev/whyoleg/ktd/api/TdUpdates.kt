package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains a list of updates
 *
 * @property updates List of updates
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("updates")
data class TdUpdates(
    @SerialName("updates")
    val updates: List<TdUpdate>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
