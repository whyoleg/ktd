package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

/**
 * A user changed the answer to a poll
 *
 * @property pollId Unique poll identifier
 * @property userId The user, who changed the answer to the poll
 * @property optionIds 0-based identifiers of answer options, chosen by the user
 */
@Serializable
@SerialName("updatePollAnswer")
data class TdUpdatePollAnswer(
    @SerialName("poll_id")
    val pollId: Long,
    @SerialName("user_id")
    val userId: Int,
    @SerialName("option_ids")
    val optionIds: IntArray
) : TdUpdate
