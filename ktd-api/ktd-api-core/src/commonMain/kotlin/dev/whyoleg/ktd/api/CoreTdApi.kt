package dev.whyoleg.ktd.api

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.internal.*

@Suppress("DEPRECATION_ERROR")
object CoreTdApi : TdApi by JsonTdApi("1.6.0", coreApiBuilder)

