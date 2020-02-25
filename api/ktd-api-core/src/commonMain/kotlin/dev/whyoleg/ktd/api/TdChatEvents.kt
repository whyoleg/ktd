package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains a list of chat events
 *
 * @property events List of events
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("chatEvents")
data class TdChatEvents(
    @SerialName("events")
    val events: List<TdChatEvent>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
