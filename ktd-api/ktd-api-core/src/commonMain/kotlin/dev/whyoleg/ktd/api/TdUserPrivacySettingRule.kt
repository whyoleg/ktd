package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a single rule for managing privacy settings
 */
@Serializable
sealed class TdUserPrivacySettingRule : TdObject {
    /**
     * A rule to allow all users to do something
     */
    @Serializable
    @SerialName("userPrivacySettingRuleAllowAll")
    object AllowAll : TdUserPrivacySettingRule()

    /**
     * A rule to allow all of a user's contacts to do something
     */
    @Serializable
    @SerialName("userPrivacySettingRuleAllowContacts")
    object AllowContacts : TdUserPrivacySettingRule()

    /**
     * A rule to allow certain specified users to do something
     *
     * @property userIds The user identifiers, total number of users in all rules must not exceed 1000
     */
    @Serializable
    @SerialName("userPrivacySettingRuleAllowUsers")
    data class AllowUsers(
        @SerialName("user_ids")
        val userIds: IntArray
    ) : TdUserPrivacySettingRule()

    /**
     * A rule to allow all members of certain specified basic groups and supergroups to doing something
     *
     * @property chatIds The chat identifiers, total number of chats in all rules must not exceed 20
     */
    @Serializable
    @SerialName("userPrivacySettingRuleAllowChatMembers")
    data class AllowChatMembers(
        @SerialName("chat_ids")
        val chatIds: LongArray
    ) : TdUserPrivacySettingRule()

    /**
     * A rule to restrict all users from doing something
     */
    @Serializable
    @SerialName("userPrivacySettingRuleRestrictAll")
    object RestrictAll : TdUserPrivacySettingRule()

    /**
     * A rule to restrict all contacts of a user from doing something
     */
    @Serializable
    @SerialName("userPrivacySettingRuleRestrictContacts")
    object RestrictContacts : TdUserPrivacySettingRule()

    /**
     * A rule to restrict all specified users from doing something
     *
     * @property userIds The user identifiers, total number of users in all rules must not exceed 1000
     */
    @Serializable
    @SerialName("userPrivacySettingRuleRestrictUsers")
    data class RestrictUsers(
        @SerialName("user_ids")
        val userIds: IntArray
    ) : TdUserPrivacySettingRule()

    /**
     * A rule to restrict all members of specified basic groups and supergroups from doing something
     *
     * @property chatIds The chat identifiers, total number of chats in all rules must not exceed 20
     */
    @Serializable
    @SerialName("userPrivacySettingRuleRestrictChatMembers")
    data class RestrictChatMembers(
        @SerialName("chat_ids")
        val chatIds: LongArray
    ) : TdUserPrivacySettingRule()
}
