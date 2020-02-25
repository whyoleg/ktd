package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes the type of a poll
 */
@Serializable
sealed class TdPollType : TdObject {
    /**
     * A regular poll
     *
     * @property allowMultipleAnswers True, if multiple answer options can be chosen simultaneously
     */
    @Serializable
    @SerialName("pollTypeRegular")
    data class Regular(
        @SerialName("allow_multiple_answers")
        val allowMultipleAnswers: Boolean
    ) : TdPollType()

    /**
     * A poll in quiz mode, which has exactly one correct answer option and can be answered only once
     *
     * @property correctOptionId 0-based identifier of the correct answer option
     *                           -1 for a yet unanswered poll
     */
    @Serializable
    @SerialName("pollTypeQuiz")
    data class Quiz(
        @SerialName("correct_option_id")
        val correctOptionId: Int
    ) : TdPollType()
}
