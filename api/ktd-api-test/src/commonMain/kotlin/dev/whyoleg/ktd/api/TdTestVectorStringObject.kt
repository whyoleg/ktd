package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * A simple object containing a vector of objects that hold a string
 *
 * @property value Vector of objects
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("testVectorStringObject")
data class TdTestVectorStringObject(
    @SerialName("value")
    val value: List<TdTestString>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
