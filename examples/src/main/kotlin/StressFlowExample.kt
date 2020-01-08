import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*
import dev.whyoleg.ktd.api.user.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.time.*

suspend fun main() {
    val telegram = Telegram(
        configuration = TelegramClientConfiguration(
            maxEventsCount = 1000,
            receiveTimeout = 0.1.seconds //ms
        )
    )
    val telegramScope = CoroutineScope(Dispatchers.Default + telegram)
    val firstClient = telegram.client()
    firstClient.authorizationStateUpdates
        .onEach {
            println(it)
            when {
                firstClient.autoHandleAuthState(it)      -> Unit
                firstClient.handlePhoneAuthorization(it) -> Unit
                it is AuthorizationStateReady            -> throw AuthComplete
                it is AuthorizationStateWaitRegistration -> firstClient.registerUser("Oleg", "Oleg")
            }
        }
        .onAuthReady()
        .collect()
    firstClient.cancelAndJoin()
    println("Provide number of clients:")
    val file = java.io.File("example/td")
    val count = readLine()!!.toInt()
    println("COPY")
    val copyTime = measureTime {
        val input = file.resolve("flow/db")
        fun output(number: Int) = file.resolve("flow$number/db")
        fun copy(file: String, number: Int) = input.resolve(file).copyTo(output(number).resolve(file))
        (0..count).forEach {
            copy("db_test.sqlite", it)
            copy("td_test.binlog", it)
        }
    }
    println(copyTime)

    println("AUTH")
    val (clients, authTime) = measureTimedValue {
        (0..count).map { i ->
            telegramScope.async {
                val client = telegram.client()
                client.authorizationStateUpdates
                    .onEach {
                        when {
                            client.autoHandleAuthState(it, "flow$i") -> Unit
                            client.handlePhoneAuthorization(it)      -> Unit
                            it is AuthorizationStateReady            -> throw AuthComplete
                        }
                    }
                    .onAuthReady()
                    .collect()
                client
            }
        }.awaitAll()
    }
    println(authTime)

    println("CONTACTS")
    val getContactsTime = measureTime {
        clients.mapIndexed { i, client ->
            telegramScope.async(telegram) {
                client.getMe()
                client.getContacts()
            }
        }.awaitAll()
    }
    println(getContactsTime)

    println("CLOSING")
    val closeTime = measureTime { telegram.cancelAndJoin() }
    println(closeTime)
    file.deleteRecursively()
}
