@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.poll

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Changes user answer to a poll
 *
 * @chatId - Identifier of the chat to which the poll belongs
 * @messageId - Identifier of the message containing the poll
 * @optionIds - 0-based identifiers of options, chosen by the user
 *              Currently user can't choose more than 1 option
 */
suspend fun TelegramClient.setPollAnswer(
    chatId: Long = 0L,
    messageId: Long = 0L,
    optionIds: IntArray = intArrayOf()
): Ok = poll(
    SetPollAnswer(
        chatId,
        messageId,
        optionIds
    )
)

/**
 * Changes user answer to a poll
 */
suspend fun TelegramClient.poll(
    f: SetPollAnswer
): Ok = exec(f) as Ok
