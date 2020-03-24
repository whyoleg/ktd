package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about a chat administrator
 *
 * @property userId User identifier of the administrator
 * @property customTitle Custom title of the administrator
 * @property isOwner True, if the user is the owner of the chat
 */
@Serializable
@SerialName("chatAdministrator")
data class TdChatAdministrator(
    @SerialName("user_id")
    val userId: Int,
    @SerialName("custom_title")
    val customTitle: String,
    @SerialName("is_owner")
    val isOwner: Boolean
) : TdObject
