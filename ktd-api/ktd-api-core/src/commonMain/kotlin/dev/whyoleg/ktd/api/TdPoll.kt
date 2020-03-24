package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes a poll
 *
 * @property id Unique poll identifier
 * @property question Poll question, 1-255 characters
 * @property options List of poll answer options
 * @property totalVoterCount Total number of voters, participating in the poll
 * @property recentVoterUserIds User identifiers of recent voters, if the poll is non-anonymous
 * @property isAnonymous True, if the poll is anonymous
 * @property type Type of the poll
 * @property isClosed True, if the poll is closed
 */
@Serializable
@SerialName("poll")
data class TdPoll(
    @SerialName("id")
    val id: Long,
    @SerialName("question")
    val question: String,
    @SerialName("options")
    val options: List<TdPollOption>,
    @SerialName("total_voter_count")
    val totalVoterCount: Int,
    @SerialName("recent_voter_user_ids")
    val recentVoterUserIds: IntArray,
    @SerialName("is_anonymous")
    val isAnonymous: Boolean,
    @SerialName("type")
    val type: TdPollType,
    @SerialName("is_closed")
    val isClosed: Boolean
) : TdObject
