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
 *
 * @name - The name of the option
 */
suspend fun TelegramClient.getOption(
    name: String? = null
): OptionValue = option(
    GetOption(
        name
    )
)

/**
 * Returns the value of an option by its name
 * (Check the list of available options on https://core.telegram.org/tdlib/options.) Can be called before authorization
 */
suspend fun TelegramClient.option(
    f: GetOption
): OptionValue = exec(f) as OptionValue
