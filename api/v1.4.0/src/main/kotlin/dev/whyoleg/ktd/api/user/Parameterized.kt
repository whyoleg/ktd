@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.user

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns the current user
 */
suspend fun TelegramClient.getMe(): User = user(
    GetMe()
)

/**
 * Returns information about a user by their identifier
 * This is an offline request if the current user is not a bot
 *
 * @userId - User identifier
 */
suspend fun TelegramClient.getUser(
    userId: Int = 0
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
    userId: Int = 0
): UserFullInfo = user(
    GetUserFullInfo(
        userId
    )
)

/**
 * Returns a list of users who are administrators of the chat
 *
 * @chatId - Chat identifier
 */
suspend fun TelegramClient.getChatAdministrators(
    chatId: Long = 0L
): Users = user(
    GetChatAdministrators(
        chatId
    )
)

/**
 * Adds a user to the blacklist
 *
 * @userId - User identifier
 */
suspend fun TelegramClient.blockUser(
    userId: Int = 0
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
    userId: Int = 0
): Ok = user(
    UnblockUser(
        userId
    )
)

/**
 * Returns users that were blocked by the current user
 *
 * @offset - Number of users to skip in the result
 * @limit - Maximum number of users to return
 */
suspend fun TelegramClient.getBlockedUsers(
    offset: Int = 0,
    limit: Int = 0
): Users = user(
    GetBlockedUsers(
        offset,
        limit
    )
)

/**
 * Returns all user contacts
 */
suspend fun TelegramClient.getContacts(): Users = user(
    GetContacts()
)

/**
 * Searches for the specified query in the first names, last names and usernames of the known user contacts
 *
 * @query - Query to search for
 *          May be empty to return all contacts
 * @limit - Maximum number of users to be returned
 */
suspend fun TelegramClient.searchContacts(
    query: String,
    limit: Int = 0
): Users = user(
    SearchContacts(
        query,
        limit
    )
)

/**
 * Returns the profile photos of a user
 * The result of this query may be outdated: some photos might have been deleted already
 *
 * @userId - User identifier
 * @offset - The number of photos to skip
 * @limit - Maximum number of photos to be returned
 */
suspend fun TelegramClient.getUserProfilePhotos(
    userId: Int = 0,
    offset: Int = 0,
    limit: Int = 0
): UserProfilePhotos = user(
    GetUserProfilePhotos(
        userId,
        offset,
        limit
    )
)

/**
 * Returns up to 20 recently used inline bots in the order of their last usage
 */
suspend fun TelegramClient.getRecentInlineBots(): Users = user(
    GetRecentInlineBots()
)

/**
 * Changes the first and last name of the current user
 * If something changes, updateUser will be sent
 *
 * @firstName - The new value of the first name for the user
 * @lastName - The new value of the optional last name for the user
 */
suspend fun TelegramClient.setName(
    firstName: String,
    lastName: String
): Ok = user(
    SetName(
        firstName,
        lastName
    )
)

/**
 * Changes the bio of the current user
 *
 * @bio - The new value of the user bio
 */
suspend fun TelegramClient.setBio(
    bio: String
): Ok = user(
    SetBio(
        bio
    )
)

/**
 * Changes the username of the current user
 * If something changes, updateUser will be sent
 *
 * @username - The new value of the username
 *             Use an empty string to remove the username
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
