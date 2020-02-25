package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about one website the current user is logged in with Telegram
 *
 * @property id Website identifier
 * @property domainName The domain name of the website
 * @property botUserId User identifier of a bot linked with the website
 * @property browser The version of a browser used to log in
 * @property platform Operating system the browser is running on
 * @property logInDate Point in time (Unix timestamp) when the user was logged in
 * @property lastActiveDate Point in time (Unix timestamp) when obtained authorization was last used
 * @property ip IP address from which the user was logged in, in human-readable format
 * @property location Human-readable description of a country and a region, from which the user was logged in, based on the IP address
 */
@Serializable
@SerialName("connectedWebsite")
data class TdConnectedWebsite(
    @SerialName("id")
    val id: Long,
    @SerialName("domain_name")
    val domainName: String,
    @SerialName("bot_user_id")
    val botUserId: Int,
    @SerialName("browser")
    val browser: String,
    @SerialName("platform")
    val platform: String,
    @SerialName("log_in_date")
    val logInDate: Int,
    @SerialName("last_active_date")
    val lastActiveDate: Int,
    @SerialName("ip")
    val ip: String,
    @SerialName("location")
    val location: String
) : TdObject
