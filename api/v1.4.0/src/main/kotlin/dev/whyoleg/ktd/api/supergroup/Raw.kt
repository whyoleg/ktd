@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.supergroup

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns information about a supergroup or channel by its identifier
 * This is an offline request if the current user is not a bot
 */
suspend fun TelegramClient.supergroup(
    f: GetSupergroup
): Supergroup = exec(f) as Supergroup

/**
 * Returns full information about a supergroup or channel by its identifier, cached for up to 1 minute
 */
suspend fun TelegramClient.supergroup(
    f: GetSupergroupFullInfo
): SupergroupFullInfo = exec(f) as SupergroupFullInfo

/**
 * Changes the username of a supergroup or channel, requires creator privileges in the supergroup or channel
 */
suspend fun TelegramClient.supergroup(
    f: SetSupergroupUsername
): Ok = exec(f) as Ok

/**
 * Changes the sticker set of a supergroup
 * Requires appropriate rights in the supergroup
 */
suspend fun TelegramClient.supergroup(
    f: SetSupergroupStickerSet
): Ok = exec(f) as Ok

/**
 * Toggles whether all members of a supergroup can add new members
 * Requires appropriate administrator rights in the supergroup.
 */
suspend fun TelegramClient.supergroup(
    f: ToggleSupergroupInvites
): Ok = exec(f) as Ok

/**
 * Toggles sender signatures messages sent in a channel
 * Requires appropriate administrator rights in the channel.
 */
suspend fun TelegramClient.supergroup(
    f: ToggleSupergroupSignMessages
): Ok = exec(f) as Ok

/**
 * Toggles whether the message history of a supergroup is available to new members
 * Requires appropriate administrator rights in the supergroup.
 */
suspend fun TelegramClient.supergroup(
    f: ToggleSupergroupIsAllHistoryAvailable
): Ok = exec(f) as Ok

/**
 * Changes information about a supergroup or channel
 * Requires appropriate administrator rights
 */
suspend fun TelegramClient.supergroup(
    f: SetSupergroupDescription
): Ok = exec(f) as Ok

/**
 * Reports some messages from a user in a supergroup as spam
 * Requires administrator rights in the supergroup
 */
suspend fun TelegramClient.supergroup(
    f: ReportSupergroupSpam
): Ok = exec(f) as Ok

/**
 * Deletes a supergroup or channel along with all messages in the corresponding chat
 * This will release the supergroup or channel username and remove all members
 * Requires creator privileges in the supergroup or channel
 * Chats with more than 1000 members can't be deleted using this method
 */
suspend fun TelegramClient.supergroup(
    f: DeleteSupergroup
): Ok = exec(f) as Ok
