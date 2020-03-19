package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

/**
 * Some messages were deleted
 *
 * @property chatId Chat identifier
 * @property messageIds Identifiers of the deleted messages
 * @property isPermanent True, if the messages are permanently deleted by a user (as opposed to just becoming inaccessible)
 * @property fromCache True, if the messages are deleted only from the cache and can possibly be retrieved again in the future
 */
@Serializable
@SerialName("updateDeleteMessages")
data class TdUpdateDeleteMessages(
    @SerialName("chat_id")
    val chatId: Long,
    @SerialName("message_ids")
    val messageIds: LongArray,
    @SerialName("is_permanent")
    val isPermanent: Boolean,
    @SerialName("from_cache")
    val fromCache: Boolean
) : TdUpdate
