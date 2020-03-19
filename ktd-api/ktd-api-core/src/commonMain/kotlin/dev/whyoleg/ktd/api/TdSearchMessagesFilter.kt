package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a filter for message search results
 */
@Serializable
sealed class TdSearchMessagesFilter : TdObject {
    /**
     * Returns all found messages, no filter is applied
     */
    @Serializable
    @SerialName("searchMessagesFilterEmpty")
    object Empty : TdSearchMessagesFilter()

    /**
     * Returns only animation messages
     */
    @Serializable
    @SerialName("searchMessagesFilterAnimation")
    object Animation : TdSearchMessagesFilter()

    /**
     * Returns only audio messages
     */
    @Serializable
    @SerialName("searchMessagesFilterAudio")
    object Audio : TdSearchMessagesFilter()

    /**
     * Returns only document messages
     */
    @Serializable
    @SerialName("searchMessagesFilterDocument")
    object Document : TdSearchMessagesFilter()

    /**
     * Returns only photo messages
     */
    @Serializable
    @SerialName("searchMessagesFilterPhoto")
    object Photo : TdSearchMessagesFilter()

    /**
     * Returns only video messages
     */
    @Serializable
    @SerialName("searchMessagesFilterVideo")
    object Video : TdSearchMessagesFilter()

    /**
     * Returns only voice note messages
     */
    @Serializable
    @SerialName("searchMessagesFilterVoiceNote")
    object VoiceNote : TdSearchMessagesFilter()

    /**
     * Returns only photo and video messages
     */
    @Serializable
    @SerialName("searchMessagesFilterPhotoAndVideo")
    object PhotoAndVideo : TdSearchMessagesFilter()

    /**
     * Returns only messages containing URLs
     */
    @Serializable
    @SerialName("searchMessagesFilterUrl")
    object Url : TdSearchMessagesFilter()

    /**
     * Returns only messages containing chat photos
     */
    @Serializable
    @SerialName("searchMessagesFilterChatPhoto")
    object ChatPhoto : TdSearchMessagesFilter()

    /**
     * Returns only call messages
     */
    @Serializable
    @SerialName("searchMessagesFilterCall")
    object Call : TdSearchMessagesFilter()

    /**
     * Returns only incoming call messages with missed/declined discard reasons
     */
    @Serializable
    @SerialName("searchMessagesFilterMissedCall")
    object MissedCall : TdSearchMessagesFilter()

    /**
     * Returns only video note messages
     */
    @Serializable
    @SerialName("searchMessagesFilterVideoNote")
    object VideoNote : TdSearchMessagesFilter()

    /**
     * Returns only voice and video note messages
     */
    @Serializable
    @SerialName("searchMessagesFilterVoiceAndVideoNote")
    object VoiceAndVideoNote : TdSearchMessagesFilter()

    /**
     * Returns only messages with mentions of the current user, or messages that are replies to their messages
     */
    @Serializable
    @SerialName("searchMessagesFilterMention")
    object Mention : TdSearchMessagesFilter()

    /**
     * Returns only messages with unread mentions of the current user, or messages that are replies to their messages
     * When using this filter the results can't be additionally filtered by a query or by the sending user
     */
    @Serializable
    @SerialName("searchMessagesFilterUnreadMention")
    object UnreadMention : TdSearchMessagesFilter()
}
