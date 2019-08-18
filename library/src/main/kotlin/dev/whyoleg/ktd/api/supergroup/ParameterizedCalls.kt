@file:Suppress("unused")

package dev.whyoleg.ktd.api.supergroup

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns information about a supergroup or channel by its identifier. This is an offline request if the current user is not a bot
 *
 * @supergroupId - Supergroup or channel identifier
 */
suspend fun TelegramClient.getSupergroup(
    supergroupId: Int
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
    supergroupId: Int
): SupergroupFullInfo = supergroup(
    GetSupergroupFullInfo(
        supergroupId
    )
)

/**
 * Changes the username of a supergroup or channel, requires creator privileges in the supergroup or channel
 *
 * @supergroupId - Identifier of the supergroup or channel
 * @username - New value of the username. Use an empty string to remove the username
 */
suspend fun TelegramClient.setSupergroupUsername(
    supergroupId: Int,
    username: String
): Ok = supergroup(
    SetSupergroupUsername(
        supergroupId,
        username
    )
)

/**
 * Changes the sticker set of a supergroup; requires appropriate rights in the supergroup
 *
 * @supergroupId - Identifier of the supergroup
 * @stickerSetId - New value of the supergroup sticker set identifier. Use 0 to remove the supergroup sticker set
 */
suspend fun TelegramClient.setSupergroupStickerSet(
    supergroupId: Int,
    stickerSetId: Long
): Ok = supergroup(
    SetSupergroupStickerSet(
        supergroupId,
        stickerSetId
    )
)

/**
 * Toggles whether all members of a supergroup can add new members; requires appropriate administrator rights in the supergroup.
 *
 * @supergroupId - Identifier of the supergroup
 * @anyoneCanInvite - New value of anyoneCanInvite
 */
suspend fun TelegramClient.toggleSupergroupInvites(
    supergroupId: Int,
    anyoneCanInvite: Boolean
): Ok = supergroup(
    ToggleSupergroupInvites(
        supergroupId,
        anyoneCanInvite
    )
)

/**
 * Toggles sender signatures messages sent in a channel; requires appropriate administrator rights in the channel.
 *
 * @supergroupId - Identifier of the channel
 * @signMessages - New value of signMessages
 */
suspend fun TelegramClient.toggleSupergroupSignMessages(
    supergroupId: Int,
    signMessages: Boolean
): Ok = supergroup(
    ToggleSupergroupSignMessages(
        supergroupId,
        signMessages
    )
)

/**
 * Toggles whether the message history of a supergroup is available to new members; requires appropriate administrator rights in the supergroup.
 *
 * @supergroupId - The identifier of the supergroup
 * @isAllHistoryAvailable - The new value of isAllHistoryAvailable
 */
suspend fun TelegramClient.toggleSupergroupIsAllHistoryAvailable(
    supergroupId: Int,
    isAllHistoryAvailable: Boolean
): Ok = supergroup(
    ToggleSupergroupIsAllHistoryAvailable(
        supergroupId,
        isAllHistoryAvailable
    )
)

/**
 * Changes information about a supergroup or channel; requires appropriate administrator rights
 *
 * @supergroupId - Identifier of the supergroup or channel
 * @paramDescription - New supergroup or channel description; 0-255 characters
 */
suspend fun TelegramClient.setSupergroupDescription(
    supergroupId: Int,
    description: String
): Ok = supergroup(
    SetSupergroupDescription(
        supergroupId,
        description
    )
)

/**
 * Reports some messages from a user in a supergroup as spam; requires administrator rights in the supergroup
 *
 * @supergroupId - Supergroup identifier
 * @userId - User identifier
 * @messageIds - Identifiers of messages sent in the supergroup by the user. This list must be non-empty
 */
suspend fun TelegramClient.reportSupergroupSpam(
    supergroupId: Int,
    userId: Int,
    messageIds: LongArray
): Ok = supergroup(
    ReportSupergroupSpam(
        supergroupId,
        userId,
        messageIds
    )
)

/**
 * Deletes a supergroup or channel along with all messages in the corresponding chat. This will release the supergroup or channel username and remove all members; requires creator privileges in the supergroup or channel. Chats with more than 1000 members can't be deleted using this method
 *
 * @supergroupId - Identifier of the supergroup or channel
 */
suspend fun TelegramClient.deleteSupergroup(
    supergroupId: Int
): Ok = supergroup(
    DeleteSupergroup(
        supergroupId
    )
)
