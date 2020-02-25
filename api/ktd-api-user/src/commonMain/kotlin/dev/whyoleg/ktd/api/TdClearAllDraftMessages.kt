package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Clears draft messages in all chats
 *
 * @property excludeSecretChats If true, local draft messages in secret chats will not be cleared
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("clearAllDraftMessages")
data class TdClearAllDraftMessages(
    @SerialName("exclude_secret_chats")
    val excludeSecretChats: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdClearAllDraftMessages {
        return copy(extra = extra.copy(id = id))
    }
}
