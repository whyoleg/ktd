package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains the call identifier
 *
 * @property id Call identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("callId")
data class TdCallId(
    @SerialName("id")
    val id: Int,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
