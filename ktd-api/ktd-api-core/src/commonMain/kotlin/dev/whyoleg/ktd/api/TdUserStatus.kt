package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes the last time the user was online
 */
@Serializable
sealed class TdUserStatus : TdObject {
    /**
     * The user status was never changed
     */
    @Serializable
    @SerialName("userStatusEmpty")
    object Empty : TdUserStatus()

    /**
     * The user is online
     *
     * @property expires Point in time (Unix timestamp) when the user's online status will expire
     */
    @Serializable
    @SerialName("userStatusOnline")
    data class Online(
        @SerialName("expires")
        val expires: Int
    ) : TdUserStatus()

    /**
     * The user is offline
     *
     * @property wasOnline Point in time (Unix timestamp) when the user was last online
     */
    @Serializable
    @SerialName("userStatusOffline")
    data class Offline(
        @SerialName("was_online")
        val wasOnline: Int
    ) : TdUserStatus()

    /**
     * The user was online recently
     */
    @Serializable
    @SerialName("userStatusRecently")
    object Recently : TdUserStatus()

    /**
     * The user is offline, but was online last week
     */
    @Serializable
    @SerialName("userStatusLastWeek")
    object LastWeek : TdUserStatus()

    /**
     * The user is offline, but was online last month
     */
    @Serializable
    @SerialName("userStatusLastMonth")
    object LastMonth : TdUserStatus()
}
