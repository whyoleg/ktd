package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about one session in a Telegram application used by the current user
 * Sessions should be shown to the user in the returned order
 *
 * @property id Session identifier
 * @property isCurrent True, if this session is the current session
 * @property isPasswordPending True, if a password is needed to complete authorization of the session
 * @property apiId Telegram API identifier, as provided by the application
 * @property applicationName Name of the application, as provided by the application
 * @property applicationVersion The version of the application, as provided by the application
 * @property isOfficialApplication True, if the application is an official application or uses the api_id of an official application
 * @property deviceModel Model of the device the application has been run or is running on, as provided by the application
 * @property platform Operating system the application has been run or is running on, as provided by the application
 * @property systemVersion Version of the operating system the application has been run or is running on, as provided by the application
 * @property logInDate Point in time (Unix timestamp) when the user has logged in
 * @property lastActiveDate Point in time (Unix timestamp) when the session was last used
 * @property ip IP address from which the session was created, in human-readable format
 * @property country A two-letter country code for the country from which the session was created, based on the IP address
 * @property region Region code from which the session was created, based on the IP address
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("session")
data class TdSession(
    @SerialName("id")
    val id: Long,
    @SerialName("is_current")
    val isCurrent: Boolean,
    @SerialName("is_password_pending")
    val isPasswordPending: Boolean,
    @SerialName("api_id")
    val apiId: Int,
    @SerialName("application_name")
    val applicationName: String,
    @SerialName("application_version")
    val applicationVersion: String,
    @SerialName("is_official_application")
    val isOfficialApplication: Boolean,
    @SerialName("device_model")
    val deviceModel: String,
    @SerialName("platform")
    val platform: String,
    @SerialName("system_version")
    val systemVersion: String,
    @SerialName("log_in_date")
    val logInDate: Int,
    @SerialName("last_active_date")
    val lastActiveDate: Int,
    @SerialName("ip")
    val ip: String,
    @SerialName("country")
    val country: String,
    @SerialName("region")
    val region: String,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
