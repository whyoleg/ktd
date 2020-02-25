package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

/**
 * Some data of a secret chat has changed
 * This update is guaranteed to come before the secret chat identifier is returned to the client
 *
 * @property secretChat New data about the secret chat
 */
@Serializable
@SerialName("updateSecretChat")
data class TdUpdateSecretChat(
    @SerialName("secret_chat")
    val secretChat: TdSecretChat
) : TdUpdate
