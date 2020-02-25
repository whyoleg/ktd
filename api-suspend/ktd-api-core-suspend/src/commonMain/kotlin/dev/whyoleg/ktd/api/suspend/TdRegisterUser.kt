package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Finishes user registration
 * Works only when the current authorization state is authorizationStateWaitRegistration
 *
 * @property firstName The first name of the user
 * @property lastName The last name of the user
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.registerUser(
    firstName: String? = null,
    lastName: String? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdRegisterUser(firstName, lastName, extra))
