@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.option

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns the value of an option by its name
 * (Check the list of available options on https://core.telegram.org/tdlib/options.) Can be called before authorization
 */
suspend fun TelegramClient.option(
    f: GetOption
): OptionValue = exec(f) as OptionValue

/**
 * Sets the value of an option
 * (Check the list of available options on https://core.telegram.org/tdlib/options.) Only writable options can be set
 * Can be called before authorization
 */
suspend fun TelegramClient.option(
    f: SetOption
): Ok = exec(f) as Ok
