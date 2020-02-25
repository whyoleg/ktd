package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes the different types of activity in a chat
 */
@Serializable
sealed class TdChatAction : TdObject {
    /**
     * The user is typing a message
     */
    @Serializable
    @SerialName("chatActionTyping")
    object Typing : TdChatAction()

    /**
     * The user is recording a video
     */
    @Serializable
    @SerialName("chatActionRecordingVideo")
    object RecordingVideo : TdChatAction()

    /**
     * The user is uploading a video
     *
     * @property progress Upload progress, as a percentage
     */
    @Serializable
    @SerialName("chatActionUploadingVideo")
    data class UploadingVideo(
        @SerialName("progress")
        val progress: Int
    ) : TdChatAction()

    /**
     * The user is recording a voice note
     */
    @Serializable
    @SerialName("chatActionRecordingVoiceNote")
    object RecordingVoiceNote : TdChatAction()

    /**
     * The user is uploading a voice note
     *
     * @property progress Upload progress, as a percentage
     */
    @Serializable
    @SerialName("chatActionUploadingVoiceNote")
    data class UploadingVoiceNote(
        @SerialName("progress")
        val progress: Int
    ) : TdChatAction()

    /**
     * The user is uploading a photo
     *
     * @property progress Upload progress, as a percentage
     */
    @Serializable
    @SerialName("chatActionUploadingPhoto")
    data class UploadingPhoto(
        @SerialName("progress")
        val progress: Int
    ) : TdChatAction()

    /**
     * The user is uploading a document
     *
     * @property progress Upload progress, as a percentage
     */
    @Serializable
    @SerialName("chatActionUploadingDocument")
    data class UploadingDocument(
        @SerialName("progress")
        val progress: Int
    ) : TdChatAction()

    /**
     * The user is picking a location or venue to send
     */
    @Serializable
    @SerialName("chatActionChoosingLocation")
    object ChoosingLocation : TdChatAction()

    /**
     * The user is picking a contact to send
     */
    @Serializable
    @SerialName("chatActionChoosingContact")
    object ChoosingContact : TdChatAction()

    /**
     * The user has started to play a game
     */
    @Serializable
    @SerialName("chatActionStartPlayingGame")
    object StartPlayingGame : TdChatAction()

    /**
     * The user is recording a video note
     */
    @Serializable
    @SerialName("chatActionRecordingVideoNote")
    object RecordingVideoNote : TdChatAction()

    /**
     * The user is uploading a video note
     *
     * @property progress Upload progress, as a percentage
     */
    @Serializable
    @SerialName("chatActionUploadingVideoNote")
    data class UploadingVideoNote(
        @SerialName("progress")
        val progress: Int
    ) : TdChatAction()

    /**
     * The user has cancelled the previous action
     */
    @Serializable
    @SerialName("chatActionCancel")
    object Cancel : TdChatAction()
}
