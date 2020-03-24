package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

@Serializable
sealed class TdUpdateBasicGroup : TdUpdate {
    /**
     * Some data of a basic group has changed
     * This update is guaranteed to come before the basic group identifier is returned to the client
     *
     * @property basicGroup New data about the group
     */
    @Serializable
    @SerialName("updateBasicGroup")
    data class Data(
        @SerialName("basic_group")
        val basicGroup: TdBasicGroup
    ) : TdUpdateBasicGroup()

    /**
     * Some data from basicGroupFullInfo has been changed
     *
     * @property basicGroupId Identifier of a basic group
     * @property basicGroupFullInfo New full information about the group
     */
    @Serializable
    @SerialName("updateBasicGroupFullInfo")
    data class FullInfo(
        @SerialName("basic_group_id")
        val basicGroupId: Int,
        @SerialName("basic_group_full_info")
        val basicGroupFullInfo: TdBasicGroupFullInfo
    ) : TdUpdateBasicGroup()
}
