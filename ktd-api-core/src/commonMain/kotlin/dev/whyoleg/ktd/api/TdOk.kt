package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * An object of this type is returned on a successful function call for certain functions
 */
@Serializable
@SerialName("ok")
data class TdOk(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
