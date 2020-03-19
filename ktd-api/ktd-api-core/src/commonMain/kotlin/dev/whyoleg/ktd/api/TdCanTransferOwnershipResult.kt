package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents result of checking whether the current session can be used to transfer a chat ownership to another user
 */
@Serializable
sealed class TdCanTransferOwnershipResult : TdResponse {
    /**
     * The session can be used
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("canTransferOwnershipResultOk")
    data class Ok(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdCanTransferOwnershipResult()

    /**
     * The 2-step verification needs to be enabled first
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("canTransferOwnershipResultPasswordNeeded")
    data class PasswordNeeded(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdCanTransferOwnershipResult()

    /**
     * The 2-step verification was enabled recently, user needs to wait
     *
     * @property retryAfter Time left before the session can be used to transfer ownership of a chat, in seconds
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("canTransferOwnershipResultPasswordTooFresh")
    data class PasswordTooFresh(
        @SerialName("retry_after")
        val retryAfter: Int,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdCanTransferOwnershipResult()

    /**
     * The session was created recently, user needs to wait
     *
     * @property retryAfter Time left before the session can be used to transfer ownership of a chat, in seconds
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("canTransferOwnershipResultSessionTooFresh")
    data class SessionTooFresh(
        @SerialName("retry_after")
        val retryAfter: Int,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdCanTransferOwnershipResult()
}
