package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents result of checking whether a username can be set for a chat
 */
@Serializable
sealed class TdCheckChatUsernameResult : TdResponse {
    /**
     * The username can be set
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("checkChatUsernameResultOk")
    data class Ok(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdCheckChatUsernameResult()

    /**
     * The username is invalid
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("checkChatUsernameResultUsernameInvalid")
    data class UsernameInvalid(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdCheckChatUsernameResult()

    /**
     * The username is occupied
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("checkChatUsernameResultUsernameOccupied")
    data class UsernameOccupied(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdCheckChatUsernameResult()

    /**
     * The user has too much chats with username, one of them should be made private first
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("checkChatUsernameResultPublicChatsTooMuch")
    data class PublicChatsTooMuch(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdCheckChatUsernameResult()

    /**
     * The user can't be a member of a public supergroup
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("checkChatUsernameResultPublicGroupsUnavailable")
    data class PublicGroupsUnavailable(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdCheckChatUsernameResult()
}
