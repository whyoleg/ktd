package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

/**
 * A poll was updated
 *
 * @property poll New data about the poll
 */
@Serializable
@SerialName("updatePoll")
data class TdUpdatePoll(
    @SerialName("poll")
    val poll: TdPoll
) : TdUpdate
