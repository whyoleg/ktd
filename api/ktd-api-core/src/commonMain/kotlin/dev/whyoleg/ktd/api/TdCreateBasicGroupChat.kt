package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns an existing chat corresponding to a known basic group
 *
 * @property basicGroupId Basic group identifier
 * @property force If true, the chat will be created without network request
 *                 In this case all information about the chat except its type, title and photo can be incorrect
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("createBasicGroupChat")
data class TdCreateBasicGroupChat(
    @SerialName("basic_group_id")
    val basicGroupId: Int = 0,
    @SerialName("force")
    val force: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdChat> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdCreateBasicGroupChat {
        return copy(extra = extra.copy(id = id))
    }
}
