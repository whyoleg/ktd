import dev.whyoleg.kamp.builtin.*
import org.gradle.internal.os.*

object Versions {

    val builtIn = BuiltInVersions(
        atomicfu = "0.12.9",
        coroutines = "1.3.0-M2",
        detekt = "1.0.0-RC16",
        docker = "1.3.0",
        kotlin = "1.3.40",
        ktor = "1.2.2",
        serialization = "0.11.1",
        shadow = "5.1.0",
        updates = "0.21.0"
    )

    const val jdk = "1.8"
    const val java = "11.0.2"

    //Plugins
    const val kamp = "0.1.0"

    //Common
    const val logging = "1.6.26"
    const val krypto = "1.6.0"

    //Waiting common
    const val koin = "2.0.1"

    //Client
    const val sqlDelight = "1.1.3"
    const val tornadofx = "2.0.0-RC1"
    val openjfx = "$java:${OperatingSystem.current().run {
        when {
            isWindows -> "win"
            isLinux   -> "linux"
            isMacOsX  -> "mac"
            else      -> error("Unknown OS")
        }
    }}"

    //Server
    const val vertx = "3.7.1"
    const val logback = "1.3.0-alpha4"
    const val micrometer = "1.1.1"
    const val slf4j = "2.0.0-alpha0"
    const val zookeeper = "3.4.14"
    const val curator = "2.13.0"

    //Database
    const val vertxJooq = "4.1.0"
    const val jooq = "3.11.9"
    const val postgresql = "42.2.6"
    const val flyway = "6.0.0-beta2"
    const val jaxbCore = "2.3.0.1"
    const val jaxbImpl = "2.4.0-b180830.0438"
    const val activation = "1.1.1"
    const val javaxAnnotations = "1.3.2"
    const val xml = "1.5.1"
    const val pgEmbedded = "0.13.1"
}