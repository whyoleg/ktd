import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*
import dev.whyoleg.ktd.api.authentication.*
import dev.whyoleg.ktd.api.check.*
import dev.whyoleg.ktd.api.database.*
import dev.whyoleg.ktd.api.user.*
import dev.whyoleg.ktd.api.users.*
import dev.whyoleg.ktd.api.util.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

suspend fun main() {
    val job = Job()
    val telegram = Telegram(
        parent = job,
        configuration = TelegramClientConfiguration(
            maxEventsCount = 1000,
            receiveTimeout = 0.01 //ms
        )
    )
    val client = telegram.client()
    client.updates.filterIsInstance<UpdateAuthorizationState>().collect {
        when (it.authorizationState) {
            is AuthorizationStateWaitTdlibParameters -> {
                println("Send parameters")
                client.setTdlibParameters(
                    parameters = TdlibParameters(
                        useTestDc = false,
                        databaseDirectory = "db",
                        filesDirectory = "files",
                        useFileDatabase = true,
                        useChatInfoDatabase = true,
                        useMessageDatabase = true,
                        apiId = 1, //provide id
                        apiHash = "", //provide hash
                        systemLanguageCode = "en",
                        deviceModel = "",
                        systemVersion = "",
                        applicationVersion = "1",
                        enableStorageOptimizer = false,
                        ignoreFileNames = false,
                        useSecretChats = false
                    )
                )
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
                val me: User = client.getMe()
                println("Your username: ${me.username}")
                val users: Users = client.getContacts()
                println("Users:")
                users.userIds.forEach {
                    val user: User = client.getUser(it)
                    if (!user.username.isNullOrBlank()) println(user.username)
                }
                job.cancel()
            }
            is AuthorizationStateClosed              -> {
                println("TDLIB closed, finish")
            }
        }
    }
}
