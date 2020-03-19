package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes the first and last name of the current user
 * If something changes, updateUser will be sent
 *
 * @property firstName The new value of the first name for the user
 * @property lastName The new value of the optional last name for the user
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setName")
data class TdSetName(
    @SerialName("first_name")
    val firstName: String? = null,
    @SerialName("last_name")
    val lastName: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetName {
        return copy(extra = extra.copy(id = id))
    }
}
