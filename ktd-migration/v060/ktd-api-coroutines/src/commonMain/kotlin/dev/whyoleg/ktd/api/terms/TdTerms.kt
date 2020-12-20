@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.terms

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.terms(f: TdAcceptTermsOfService): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("acceptTermsOfService(termsOfServiceId)",
            "dev.whyoleg.ktd.api.suspend.acceptTermsOfService"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.acceptTermsOfService(termsOfServiceId: String? = null): TdOk =
        exec(TdAcceptTermsOfService(termsOfServiceId))
