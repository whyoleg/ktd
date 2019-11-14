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
 *
 * @supergroupId - Supergroup or channel identifier
 */
suspend fun TelegramClient.getSupergroup(
    supergroupId: Int = 0
): Supergroup = supergroup(
    GetSupergroup(
        supergroupId
    )
)

/**
 * Returns full information about a supergroup or channel by its identifier, cached for up to 1 minute
 *
 * @supergroupId - Supergroup or channel identifier
 */
suspend fun TelegramClient.getSupergroupFullInfo(
    supergroupId: Int = 0
): SupergroupFullInfo = supergroup(
    GetSupergroupFullInfo(
        supergroupId
    )
)

/**
 * Changes the username of a supergroup or channel, requires creator privileges in the supergroup or channel
 *
 * @supergroupId - Identifier of the supergroup or channel
 * @username - New value of the username
 *             Use an empty string to remove the username
 */
suspend fun TelegramClient.setSupergroupUsername(
    supergroupId: Int = 0,
    username: String
): Ok = supergroup(
    SetSupergroupUsername(
        supergroupId,
        username
    )
)

/**
 * Changes the sticker set of a supergroup
 * Requires can_change_info rights
 *
 * @supergroupId - Identifier of the supergroup
 * @stickerSetId - New value of the supergroup sticker set identifier
 *                 Use 0 to remove the supergroup sticker set
 */
suspend fun TelegramClient.setSupergroupStickerSet(
    supergroupId: Int = 0,
    stickerSetId: Long = 0L
): Ok = supergroup(
    SetSupergroupStickerSet(
        supergroupId,
        stickerSetId
    )
)

/**
 * Toggles sender signatures messages sent in a channel
 * Requires can_change_info rights
 *
 * @supergroupId - Identifier of the channel
 * @signMessages - New value of sign_messages
 */
suspend fun TelegramClient.toggleSupergroupSignMessages(
    supergroupId: Int = 0,
    signMessages: Boolean = false
): Ok = supergroup(
    ToggleSupergroupSignMessages(
        supergroupId,
        signMessages
    )
)

/**
 * Toggles whether the message history of a supergroup is available to new members
 * Requires can_change_info rights
 *
 * @supergroupId - The identifier of the supergroup
 * @isAllHistoryAvailable - The new value of is_all_history_available
 */
suspend fun TelegramClient.toggleSupergroupIsAllHistoryAvailable(
    supergroupId: Int = 0,
    isAllHistoryAvailable: Boolean = false
): Ok = supergroup(
    ToggleSupergroupIsAllHistoryAvailable(
        supergroupId,
        isAllHistoryAvailable
    )
)

/**
 * Reports some messages from a user in a supergroup as spam
 * Requires administrator rights in the supergroup
 *
 * @supergroupId - Supergroup identifier
 * @userId - User identifier
 * @messageIds - Identifiers of messages sent in the supergroup by the user
 *               This list must be non-empty
 */
suspend fun TelegramClient.reportSupergroupSpam(
    supergroupId: Int = 0,
    userId: Int = 0,
    messageIds: LongArray = longArrayOf()
): Ok = supergroup(
    ReportSupergroupSpam(
        supergroupId,
        userId,
        messageIds
    )
)

/**
 * Deletes a supergroup or channel along with all messages in the corresponding chat
 * This will release the supergroup or channel username and remove all members
 * Requires creator privileges in the supergroup or channel
 * Chats with more than 1000 members can't be deleted using this method
 *
 * @supergroupId - Identifier of the supergroup or channel
 */
suspend fun TelegramClient.deleteSupergroup(
    supergroupId: Int = 0
): Ok = supergroup(
    DeleteSupergroup(
        supergroupId
    )
)
