package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Toggles whether the message history of a supergroup is available to new members
 * Requires can_change_info rights
 *
 * @property supergroupId The identifier of the supergroup
 * @property isAllHistoryAvailable The new value of is_all_history_available
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("toggleSupergroupIsAllHistoryAvailable")
data class TdToggleSupergroupIsAllHistoryAvailable(
    @SerialName("supergroup_id")
    val supergroupId: Int = 0,
    @SerialName("is_all_history_available")
    val isAllHistoryAvailable: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdToggleSupergroupIsAllHistoryAvailable {
        return copy(extra = extra.copy(id = id))
    }
}
