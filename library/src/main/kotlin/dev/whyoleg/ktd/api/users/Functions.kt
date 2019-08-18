@file:Suppress("unused")

package dev.whyoleg.ktd.api.users

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns a list of users who are administrators of the chat
 */
suspend fun TelegramClient.users(
    f: GetChatAdministrators
): Users = execRaw(f) as Users

/**
 * Returns users that were blocked by the current user
 */
suspend fun TelegramClient.users(
    f: GetBlockedUsers
): Users = execRaw(f) as Users

/**
 * Returns all user contacts
 */
suspend fun TelegramClient.users(
    f: GetContacts
): Users = execRaw(f) as Users

/**
 * Searches for the specified query in the first names, last names and usernames of the known user contacts
 */
suspend fun TelegramClient.users(
    f: SearchContacts
): Users = execRaw(f) as Users

/**
 * Returns up to 20 recently used inline bots in the order of their last usage
 */
suspend fun TelegramClient.users(
    f: GetRecentInlineBots
): Users = execRaw(f) as Users
