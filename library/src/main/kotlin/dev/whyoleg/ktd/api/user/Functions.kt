@file:Suppress("unused")

package dev.whyoleg.ktd.api.user

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns the current user
 */
suspend fun TelegramClient.user(
    f: GetMe
): User = execRaw(f) as User

/**
 * Returns information about a user by their identifier. This is an offline request if the current user is not a bot
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
 * Returns the profile photos of a user. The result of this query may be outdated: some photos might have been deleted already
 */
suspend fun TelegramClient.user(
    f: GetUserProfilePhotos
): UserProfilePhotos = execRaw(f) as UserProfilePhotos

/**
 * Changes the username of the current user. If something changes, updateUser will be sent
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
