package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes one answer option of a poll
 *
 * @property text Option text, 1-100 characters
 * @property voterCount Number of voters for this option, available only for closed or voted polls
 * @property votePercentage The percentage of votes for this option, 0-100
 * @property isChosen True, if the option was chosen by the user
 * @property isBeingChosen True, if the option is being chosen by a pending setPollAnswer request
 */
@Serializable
@SerialName("pollOption")
data class TdPollOption(
    @SerialName("text")
    val text: String,
    @SerialName("voter_count")
    val voterCount: Int,
    @SerialName("vote_percentage")
    val votePercentage: Int,
    @SerialName("is_chosen")
    val isChosen: Boolean,
    @SerialName("is_being_chosen")
    val isBeingChosen: Boolean
) : TdObject
