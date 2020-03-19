package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Adds an element to the user's Telegram Passport
 * May return an error with a message "PHONE_VERIFICATION_NEEDED" or "EMAIL_VERIFICATION_NEEDED" if the chosen phone number or the chosen email address must be verified first
 *
 * @property element Input Telegram Passport element
 * @property password Password of the current user
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setPassportElement(
    element: TdInputPassportElement? = null,
    password: String? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdPassportElement = exec(TdSetPassportElement(element, password, extra))
