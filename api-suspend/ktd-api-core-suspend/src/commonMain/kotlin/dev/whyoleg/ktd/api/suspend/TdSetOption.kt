package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Sets the value of an option
 * (Check the list of available options on https://core.telegram.org/tdlib/options.) Only writable options can be set
 * Can be called before authorization
 *
 * @property name The name of the option
 * @property value The new value of the option
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setOption(
    name: String? = null,
    value: TdOptionValue? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSetOption(name, value, extra))
