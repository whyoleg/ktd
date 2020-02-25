package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns the value of an option by its name
 * (Check the list of available options on https://core.telegram.org/tdlib/options.) Can be called before authorization
 *
 * @property name The name of the option
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getOption(name: String? = null, extra: TdExtra = TdExtra.EMPTY):
        TdOptionValue = exec(TdGetOption(name, extra))
