package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns backgrounds installed by the user
 *
 * @property forDarkTheme True, if the backgrounds needs to be ordered for dark theme
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getBackgrounds(forDarkTheme: Boolean = false, extra: TdExtra =
        TdExtra.EMPTY): TdBackgrounds = exec(TdGetBackgrounds(forDarkTheme, extra))
