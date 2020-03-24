package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

/**
 * The connection state has changed
 *
 * @property state The new connection state
 */
@Serializable
@SerialName("updateConnectionState")
data class TdUpdateConnectionState(
    @SerialName("state")
    val state: TdConnectionState
) : TdUpdate
