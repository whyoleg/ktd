package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Changes the background selected by the user
 * Adds background to the list of installed backgrounds
 *
 * @property background The input background to use, null for filled backgrounds
 * @property type Background type
 *                Null for default background
 *                The method will return error 404 if type is null
 * @property forDarkTheme True, if the background is chosen for dark theme
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setBackground(
    background: TdInputBackground? = null,
    type: TdBackgroundType? = null,
    forDarkTheme: Boolean = false,
    extra: TdExtra = TdExtra.EMPTY
): TdBackground = exec(TdSetBackground(background, type, forDarkTheme, extra))
