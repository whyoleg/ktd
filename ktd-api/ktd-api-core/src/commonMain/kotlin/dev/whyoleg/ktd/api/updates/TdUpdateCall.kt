package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

/**
 * New call was created or information about a call was updated
 *
 * @property call New data about a call
 */
@Serializable
@SerialName("updateCall")
data class TdUpdateCall(
    @SerialName("call")
    val call: TdCall
) : TdUpdate
