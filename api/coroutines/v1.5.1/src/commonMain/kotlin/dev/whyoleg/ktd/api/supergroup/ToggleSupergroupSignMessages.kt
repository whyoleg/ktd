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
 * Toggles sender signatures messages sent in a channel
 * Requires can_change_info rights
 */
suspend fun TelegramClient.supergroup(
    f: ToggleSupergroupSignMessages
): Ok = exec(f) as Ok
