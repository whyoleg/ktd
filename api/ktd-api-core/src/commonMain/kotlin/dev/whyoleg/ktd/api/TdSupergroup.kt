package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a supergroup or channel with zero or more members (subscribers in the case of channels)
 * From the point of view of the system, a channel is a special kind of a supergroup: only administrators can post and see the list of members, and posts from all administrators use the name and photo of the channel instead of individual names and profile photos
 * Unlike supergroups, channels can have an unlimited number of subscribers
 *
 * @property id Supergroup or channel identifier
 * @property username Username of the supergroup or channel
 *                    Empty for private supergroups or channels
 * @property date Point in time (Unix timestamp) when the current user joined, or the point in time when the supergroup or channel was created, in case the user is not a member
 * @property status Status of the current user in the supergroup or channel
 *                  Custom title will be always empty
 * @property memberCount Member count
 *                       0 if unknown
 *                       Currently it is guaranteed to be known only if the supergroup or channel was found through SearchPublicChats
 * @property hasLinkedChat True, if the channel has a discussion group, or the supergroup is the designated discussion group for a channel
 * @property hasLocation True, if the supergroup is connected to a location, i.e
 *                       The supergroup is a location-based supergroup
 * @property signMessages True, if messages sent to the channel should contain information about the sender
 *                        This field is only applicable to channels
 * @property isSlowModeEnabled True, if the slow mode is enabled in the supergroup
 * @property isChannel True, if the supergroup is a channel
 * @property isVerified True, if the supergroup or channel is verified
 * @property restrictionReason If non-empty, contains a human-readable description of the reason why access to this supergroup or channel must be restricted
 * @property isScam True, if many users reported this supergroup as a scam
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("supergroup")
data class TdSupergroup(
    @SerialName("id")
    val id: Int,
    @SerialName("username")
    val username: String,
    @SerialName("date")
    val date: Int,
    @SerialName("status")
    val status: TdChatMemberStatus,
    @SerialName("member_count")
    val memberCount: Int,
    @SerialName("has_linked_chat")
    val hasLinkedChat: Boolean,
    @SerialName("has_location")
    val hasLocation: Boolean,
    @SerialName("sign_messages")
    val signMessages: Boolean,
    @SerialName("is_slow_mode_enabled")
    val isSlowModeEnabled: Boolean,
    @SerialName("is_channel")
    val isChannel: Boolean,
    @SerialName("is_verified")
    val isVerified: Boolean,
    @SerialName("restriction_reason")
    val restrictionReason: String,
    @SerialName("is_scam")
    val isScam: Boolean,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
