package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains the result of a custom request
 *
 * @property result A JSON-serialized result
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("customRequestResult")
data class TdCustomRequestResult(
    @SerialName("result")
    val result: String,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
