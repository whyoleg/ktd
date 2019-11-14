import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*
import dev.whyoleg.ktd.api.authentication.*
import dev.whyoleg.ktd.api.check.*
import dev.whyoleg.ktd.api.database.*
import dev.whyoleg.ktd.api.tdlib.*
import dev.whyoleg.ktd.api.user.*
import kotlinx.coroutines.flow.*

fun tdlibParameters(dbPath: String = "flow") = TdlibParameters(
    useTestDc = System.getProperty("test")!!.toBoolean(),
    databaseDirectory = "example/td/$dbPath/db",
    filesDirectory = "example/td/$dbPath/files",
    useFileDatabase = true,
    useChatInfoDatabase = true,
    useMessageDatabase = true,
    apiId = System.getProperty("apiId").toInt(),//provide id
    apiHash = System.getProperty("apiHash"), //provide hash
    systemLanguageCode = "en",
    deviceModel = "Mobile",
    systemVersion = "1",
    applicationVersion = "1",
    enableStorageOptimizer = false,
    ignoreFileNames = false,
    useSecretChats = false
)

val TelegramClient.authorizationStateUpdates: Flow<AuthorizationState>
    get() = updates.filterIsInstance<UpdateAuthorizationState>().mapNotNull { it.authorizationState }

suspend fun TelegramClient.autoHandleAuthState(state: AuthorizationState, dbPath: String = "flow"): Boolean {
    when (state) {
        is AuthorizationStateWaitTdlibParameters -> setTdlibParameters(tdlibParameters(dbPath))
        is AuthorizationStateWaitEncryptionKey   -> setDatabaseEncryptionKey(ByteArray(DEFAULT_BUFFER_SIZE).apply { fill(1) })
        else                                     -> return false
    }
    return true
}

suspend fun TelegramClient.handlePhoneAuthorization(state: AuthorizationState): Boolean {
    when (state) {
        is AuthorizationStateWaitPhoneNumber -> {
            println("Provide phone")
            val phone = readLine()!!
            setAuthenticationPhoneNumber(
                phoneNumber = phone,
                settings = PhoneNumberAuthenticationSettings(
                    allowFlashCall = false,
                    isCurrentPhoneNumber = false,
                    allowSmsRetrieverApi = false
                )
            )
        }
        is AuthorizationStateWaitCode        -> {
            println("Provide code")
            val code = readLine()!!
            checkAuthenticationCode(code)
        }
        else                                 -> return false
    }
    return true
}

object AuthComplete : Throwable()

fun Flow<AuthorizationState>.onAuthReady(block: suspend () -> Unit = {}): Flow<AuthorizationState> = catch {
    if (it is AuthComplete) block() else throw it
}

suspend fun TelegramClient.showMeAndContacts() {
    val me: User = getMe()
    println("Your username: ${me.username}")
    val users: Users = getContacts()
    println("Users:")
    users.userIds.forEach {
        val user: User = getUser(it)
        if (!user.username.isBlank()) println(user.username)
    }
}

