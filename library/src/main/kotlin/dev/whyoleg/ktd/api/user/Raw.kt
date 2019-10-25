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
 * Finishes user registration
 * Works only when the current authorization state is authorizationStateWaitRegistration
 */
suspend fun TelegramClient.user(
    f: RegisterUser
): Ok = execRaw(f) as Ok

/**
 * Returns the current user
 */
suspend fun TelegramClient.user(
    f: GetMe
): User = execRaw(f) as User

/**
 * Returns information about a user by their identifier
 * This is an offline request if the current user is not a bot
 */
suspend fun TelegramClient.user(
    f: GetUser
): User = execRaw(f) as User

/**
 * Returns full information about a user by their identifier
 */
suspend fun TelegramClient.user(
    f: GetUserFullInfo
): UserFullInfo = execRaw(f) as UserFullInfo

/**
 * Returns a list of users who are administrators of the chat
 */
suspend fun TelegramClient.user(
    f: GetChatAdministrators
): Users = execRaw(f) as Users

/**
 * Adds a user to the blacklist
 */
suspend fun TelegramClient.user(
    f: BlockUser
): Ok = execRaw(f) as Ok

/**
 * Removes a user from the blacklist
 */
suspend fun TelegramClient.user(
    f: UnblockUser
): Ok = execRaw(f) as Ok

/**
 * Returns users that were blocked by the current user
 */
suspend fun TelegramClient.user(
    f: GetBlockedUsers
): Users = execRaw(f) as Users

/**
 * Returns all user contacts
 */
suspend fun TelegramClient.user(
    f: GetContacts
): Users = execRaw(f) as Users

/**
 * Searches for the specified query in the first names, last names and usernames of the known user contacts
 */
suspend fun TelegramClient.user(
    f: SearchContacts
): Users = execRaw(f) as Users

/**
 * Returns the profile photos of a user
 * The result of this query may be outdated: some photos might have been deleted already
 */
suspend fun TelegramClient.user(
    f: GetUserProfilePhotos
): UserProfilePhotos = execRaw(f) as UserProfilePhotos

/**
 * Returns up to 20 recently used inline bots in the order of their last usage
 */
suspend fun TelegramClient.user(
    f: GetRecentInlineBots
): Users = execRaw(f) as Users

/**
 * Changes the first and last name of the current user
 * If something changes, updateUser will be sent
 */
suspend fun TelegramClient.user(
    f: SetName
): Ok = execRaw(f) as Ok

/**
 * Changes the bio of the current user
 */
suspend fun TelegramClient.user(
    f: SetBio
): Ok = execRaw(f) as Ok

/**
 * Changes the username of the current user
 * If something changes, updateUser will be sent
 */
suspend fun TelegramClient.user(
    f: SetUsername
): Ok = execRaw(f) as Ok

/**
 * Returns a user that can be contacted to get support
 */
suspend fun TelegramClient.user(
    f: GetSupportUser
): User = execRaw(f) as User

/**
 * Changes user privacy settings
 */
suspend fun TelegramClient.user(
    f: SetUserPrivacySettingRules
): Ok = execRaw(f) as Ok

/**
 * Returns the current privacy settings
 */
suspend fun TelegramClient.user(
    f: GetUserPrivacySettingRules
): UserPrivacySettingRules = execRaw(f) as UserPrivacySettingRules
