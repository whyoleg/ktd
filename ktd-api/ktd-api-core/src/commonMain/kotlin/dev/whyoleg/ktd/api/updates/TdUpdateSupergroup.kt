package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

@Serializable
sealed class TdUpdateSupergroup : TdUpdate {
    /**
     * Some data of a supergroup or a channel has changed
     * This update is guaranteed to come before the supergroup identifier is returned to the client
     *
     * @property supergroup New data about the supergroup
     */
    @Serializable
    @SerialName("updateSupergroup")
    data class Data(
        @SerialName("supergroup")
        val supergroup: TdSupergroup
    ) : TdUpdateSupergroup()

    /**
     * Some data from supergroupFullInfo has been changed
     *
     * @property supergroupId Identifier of the supergroup or channel
     * @property supergroupFullInfo New full information about the supergroup
     */
    @Serializable
    @SerialName("updateSupergroupFullInfo")
    data class FullInfo(
        @SerialName("supergroup_id")
        val supergroupId: Int,
        @SerialName("supergroup_full_info")
        val supergroupFullInfo: TdSupergroupFullInfo
    ) : TdUpdateSupergroup()
}
