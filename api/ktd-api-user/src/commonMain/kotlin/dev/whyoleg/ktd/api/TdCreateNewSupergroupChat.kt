package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Creates a new supergroup or channel and sends a corresponding messageSupergroupChatCreate
 * Returns the newly created chat
 *
 * @property title Title of the new chat
 * @property isChannel True, if a channel chat should be created
 * @property description Chat description
 * @property location Chat location if a location-based supergroup is being created
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("createNewSupergroupChat")
data class TdCreateNewSupergroupChat(
    @SerialName("title")
    val title: String? = null,
    @SerialName("is_channel")
    val isChannel: Boolean = false,
    @SerialName("description")
    val description: String? = null,
    @SerialName("location")
    val location: TdChatLocation? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdChat> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdCreateNewSupergroupChat {
        return copy(extra = extra.copy(id = id))
    }
}
