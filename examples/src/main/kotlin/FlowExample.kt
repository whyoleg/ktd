import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*
import dev.whyoleg.ktd.api.sync.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.time.*

suspend fun main() {
    TelegramClient.setLogVerbosityLevel(0)
    val telegram = Telegram(
        configuration = TelegramClientConfiguration(
            maxEventsCount = 1000,
            receiveTimeout = 1.seconds //ms
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
