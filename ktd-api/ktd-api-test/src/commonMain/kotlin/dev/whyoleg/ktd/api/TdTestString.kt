package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * A simple object containing a string
 *
 * @property value String
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("testString")
data class TdTestString(
    @SerialName("value")
    val value: String,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
