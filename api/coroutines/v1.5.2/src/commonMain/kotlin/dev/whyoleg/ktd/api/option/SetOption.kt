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
 * Sets the value of an option
 * (Check the list of available options on https://core.telegram.org/tdlib/options.) Only writable options can be set
 * Can be called before authorization
 *
 * @name - The name of the option
 * @value - The new value of the option
 */
suspend fun TelegramClient.setOption(
    name: String? = null,
    value: OptionValue? = null
): Ok = option(
    SetOption(
        name,
        value
    )
)

/**
 * Sets the value of an option
 * (Check the list of available options on https://core.telegram.org/tdlib/options.) Only writable options can be set
 * Can be called before authorization
 */
suspend fun TelegramClient.option(
    f: SetOption
): Ok = exec(f) as Ok
