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

/**
 * Deletes a supergroup or channel along with all messages in the corresponding chat
 * This will release the supergroup or channel username and remove all members
 * Requires creator privileges in the supergroup or channel
 * Chats with more than 1000 members can't be deleted using this method
 */
suspend fun TelegramClient.supergroup(
    f: DeleteSupergroup
): Ok = exec(f) as Ok
