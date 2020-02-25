package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes the type of notifications in a notification group
 */
@Serializable
sealed class TdNotificationGroupType : TdObject {
    /**
     * A group containing notifications of type notificationTypeNewMessage and notificationTypeNewPushMessage with ordinary unread messages
     */
    @Serializable
    @SerialName("notificationGroupTypeMessages")
    object Messages : TdNotificationGroupType()

    /**
     * A group containing notifications of type notificationTypeNewMessage and notificationTypeNewPushMessage with unread mentions of the current user, replies to their messages, or a pinned message
     */
    @Serializable
    @SerialName("notificationGroupTypeMentions")
    object Mentions : TdNotificationGroupType()

    /**
     * A group containing a notification of type notificationTypeNewSecretChat
     */
    @Serializable
    @SerialName("notificationGroupTypeSecretChat")
    object SecretChat : TdNotificationGroupType()

    /**
     * A group containing notifications of type notificationTypeNewCall
     */
    @Serializable
    @SerialName("notificationGroupTypeCalls")
    object Calls : TdNotificationGroupType()
}
