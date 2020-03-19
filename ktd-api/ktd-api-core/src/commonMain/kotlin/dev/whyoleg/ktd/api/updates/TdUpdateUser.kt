package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

@Serializable
sealed class TdUpdateUser : TdUpdate {
    /**
     * User activity in the chat has changed
     *
     * @property chatId Chat identifier
     * @property userId Identifier of a user performing an action
     * @property action The action description
     */
    @Serializable
    @SerialName("updateUserChatAction")
    data class ChatAction(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("user_id")
        val userId: Int,
        @SerialName("action")
        val action: TdChatAction
    ) : TdUpdateUser()

    /**
     * The user went online or offline
     *
     * @property userId User identifier
     * @property status New status of the user
     */
    @Serializable
    @SerialName("updateUserStatus")
    data class Status(
        @SerialName("user_id")
        val userId: Int,
        @SerialName("status")
        val status: TdUserStatus
    ) : TdUpdateUser()

    /**
     * Some data of a user has changed
     * This update is guaranteed to come before the user identifier is returned to the client
     *
     * @property user New data about the user
     */
    @Serializable
    @SerialName("updateUser")
    data class Data(
        @SerialName("user")
        val user: TdUser
    ) : TdUpdateUser()

    /**
     * Some data from userFullInfo has been changed
     *
     * @property userId User identifier
     * @property userFullInfo New full information about the user
     */
    @Serializable
    @SerialName("updateUserFullInfo")
    data class FullInfo(
        @SerialName("user_id")
        val userId: Int,
        @SerialName("user_full_info")
        val userFullInfo: TdUserFullInfo
    ) : TdUpdateUser()

    /**
     * Some privacy setting rules have been changed
     *
     * @property setting The privacy setting
     * @property rules New privacy rules
     */
    @Serializable
    @SerialName("updateUserPrivacySettingRules")
    data class PrivacySettingRules(
        @SerialName("setting")
        val setting: TdUserPrivacySetting,
        @SerialName("rules")
        val rules: TdUserPrivacySettingRules
    ) : TdUpdateUser()
}
