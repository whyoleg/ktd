package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Reports some messages from a user in a supergroup as spam
 * Requires administrator rights in the supergroup
 *
 * @property supergroupId Supergroup identifier
 * @property userId User identifier
 * @property messageIds Identifiers of messages sent in the supergroup by the user
 *                      This list must be non-empty
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("reportSupergroupSpam")
data class TdReportSupergroupSpam(
    @SerialName("supergroup_id")
    val supergroupId: Int = 0,
    @SerialName("user_id")
    val userId: Int = 0,
    @SerialName("message_ids")
    val messageIds: LongArray = longArrayOf(),
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdReportSupergroupSpam {
        return copy(extra = extra.copy(id = id))
    }
}
