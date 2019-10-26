import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*
import dev.whyoleg.ktd.api.authentication.*
import dev.whyoleg.ktd.api.check.*
import dev.whyoleg.ktd.api.database.*
import dev.whyoleg.ktd.api.tdlib.*
import dev.whyoleg.ktd.api.user.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

suspend fun main() {
    val telegram = Telegram(
        configuration = TelegramClientConfiguration(
            maxEventsCount = 1000,
            receiveTimeout = 0.01 //ms
        )
    )
    val client = telegram.client()
    client.updates.filterIsInstance<UpdateAuthorizationState>().onEach {
        println(it.authorizationState)
        when (it.authorizationState) {
            is AuthorizationStateWaitTdlibParameters -> {
                println("Send parameters")
                client.setTdlibParameters(tdlibParameters)
            }
            is AuthorizationStateWaitEncryptionKey   -> client.setDatabaseEncryptionKey(ByteArray(DEFAULT_BUFFER_SIZE).apply { fill(1) })
            is AuthorizationStateWaitPhoneNumber     -> {
                println("Provide phone")
                val phone = readLine()!!
                client.setAuthenticationPhoneNumber(
                    phoneNumber = phone,
                    settings = PhoneNumberAuthenticationSettings(
                        allowFlashCall = false,
                        isCurrentPhoneNumber = false,
                        allowSmsRetrieverApi = false
                    )
                )
            }
            is AuthorizationStateWaitCode            -> {
                println("Provide code")
                val code = readLine()!!
                client.checkAuthenticationCode(code)
            }
            is AuthorizationStateReady               -> {
                throw Throwable()
            }
            is AuthorizationStateClosed              -> {
                println("TDLIB closed, finish")
            }
        }
    }.runCatching { collect() }

    val me: User = client.getMe()
    println("Your username: ${me.username}")
    val users: Users = client.getContacts()
    println("Users:")
    users.userIds.forEach {
        val user: User = client.getUser(it)
        if (!user.username.isNullOrBlank()) println(user.username)
    }
    telegram.cancelAndJoin()
}
