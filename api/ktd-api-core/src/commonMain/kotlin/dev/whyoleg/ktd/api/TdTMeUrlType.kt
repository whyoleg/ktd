package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes the type of a URL linking to an internal Telegram entity
 */
@Serializable
sealed class TdTMeUrlType : TdObject {
    /**
     * A URL linking to a user
     *
     * @property userId Identifier of the user
     */
    @Serializable
    @SerialName("tMeUrlTypeUser")
    data class User(
        @SerialName("user_id")
        val userId: Int
    ) : TdTMeUrlType()

    /**
     * A URL linking to a public supergroup or channel
     *
     * @property supergroupId Identifier of the supergroup or channel
     */
    @Serializable
    @SerialName("tMeUrlTypeSupergroup")
    data class Supergroup(
        @SerialName("supergroup_id")
        val supergroupId: Long
    ) : TdTMeUrlType()

    /**
     * A chat invite link
     *
     * @property info Chat invite link info
     */
    @Serializable
    @SerialName("tMeUrlTypeChatInvite")
    data class ChatInvite(
        @SerialName("info")
        val info: TdChatInviteLinkInfo
    ) : TdTMeUrlType()

    /**
     * A URL linking to a sticker set
     *
     * @property stickerSetId Identifier of the sticker set
     */
    @Serializable
    @SerialName("tMeUrlTypeStickerSet")
    data class StickerSet(
        @SerialName("sticker_set_id")
        val stickerSetId: Long
    ) : TdTMeUrlType()
}
