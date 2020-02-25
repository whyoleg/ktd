package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Checks whether the current session can be used to transfer a chat ownership to another user
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("canTransferOwnership")
data class TdCanTransferOwnership(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdCanTransferOwnershipResult> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdCanTransferOwnership {
        return copy(extra = extra.copy(id = id))
    }
}
