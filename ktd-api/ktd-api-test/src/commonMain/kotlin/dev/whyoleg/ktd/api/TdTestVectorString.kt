package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * A simple object containing a vector of strings
 *
 * @property value Vector of strings
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("testVectorString")
data class TdTestVectorString(
    @SerialName("value")
    val value: List<String>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
