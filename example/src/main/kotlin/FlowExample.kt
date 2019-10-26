import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*
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
    client.authorizationStateUpdates
        .onEach {
            when {
                client.autoHandleAuthState(it)      -> Unit
                client.handlePhoneAuthorization(it) -> Unit
                it is AuthorizationStateReady       -> throw AuthComplete
            }
        }
        .onAuthReady { println("Authorization completed") }
        .collect()
    client.showMeAndContacts()
    telegram.cancelAndJoin()
}
