@file:Suppress("unused")

package dev.whyoleg.ktd.api.user

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Finishes user registration. Works only when the current authorization state is authorizationStateWaitRegistration
 *
 * @firstName - The first name of the user; 1-64 characters
 * @lastName - The last name of the user; 0-64 characters
 */
suspend fun TelegramClient.registerUser(
    firstName: String,
    lastName: String
): Ok = user(
    RegisterUser(
        firstName,
        lastName
    )
)

/**
 * Returns the current user
 */
suspend fun TelegramClient.getMe(): User = user(
    GetMe()
)

/**
 * Returns information about a user by their identifier. This is an offline request if the current user is not a bot
 *
 * @userId - User identifier
 */
suspend fun TelegramClient.getUser(
    userId: Int
): User = user(
    GetUser(
        userId
    )
)

/**
 * Returns full information about a user by their identifier
 *
 * @userId - User identifier
 */
suspend fun TelegramClient.getUserFullInfo(
    userId: Int
): UserFullInfo = user(
    GetUserFullInfo(
        userId
    )
)

/**
 * Adds a user to the blacklist
 *
 * @userId - User identifier
 */
suspend fun TelegramClient.blockUser(
    userId: Int
): Ok = user(
    BlockUser(
        userId
    )
)

/**
 * Removes a user from the blacklist
 *
 * @userId - User identifier
 */
suspend fun TelegramClient.unblockUser(
    userId: Int
): Ok = user(
    UnblockUser(
        userId
    )
)

/**
 * Returns the profile photos of a user. The result of this query may be outdated: some photos might have been deleted already
 *
 * @userId - User identifier
 * @offset - The number of photos to skip; must be non-negative
 * @limit - Maximum number of photos to be returned; up to 100
 */
suspend fun TelegramClient.getUserProfilePhotos(
    userId: Int,
    offset: Int,
    limit: Int
): UserProfilePhotos = user(
    GetUserProfilePhotos(
        userId,
        offset,
        limit
    )
)

/**
 * Changes the username of the current user. If something changes, updateUser will be sent
 *
 * @username - The new value of the username. Use an empty string to remove the username
 */
suspend fun TelegramClient.setUsername(
    username: String
): Ok = user(
    SetUsername(
        username
    )
)

/**
 * Returns a user that can be contacted to get support
 */
suspend fun TelegramClient.getSupportUser(): User = user(
    GetSupportUser()
)

/**
 * Changes user privacy settings
 *
 * @setting - The privacy setting
 * @rules - The new privacy rules
 */
suspend fun TelegramClient.setUserPrivacySettingRules(
    setting: UserPrivacySetting,
    rules: UserPrivacySettingRules
): Ok = user(
    SetUserPrivacySettingRules(
        setting,
        rules
    )
)

/**
 * Returns the current privacy settings
 *
 * @setting - The privacy setting
 */
suspend fun TelegramClient.getUserPrivacySettingRules(
    setting: UserPrivacySetting
): UserPrivacySettingRules = user(
    GetUserPrivacySettingRules(
        setting
    )
)
