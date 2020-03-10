import dev.whyoleg.kamp.modules.*

object Versions {
    val kotlin = KotlinVersion("1.3.70")

    val kotlinx = KotlinxVersions(
        coroutines = "1.3.4",
        serialization = "0.20.0",
        atomicfu = "0.14.2",
        cli = "0.2.1",
        immutableCollections = "0.3"
        //todo add benchmarks here
    )

    val ktor = KtorVersion("1.3.1")
    const val benchmarks = "0.2.0-dev-7"

    const val githubApi = "1.108"
    const val kotlinShell = "0.2.1"
    const val kotlinPoet = "1.5.0"

    const val ktdVersion = "0.6.0"

    object Reactive {
        val rx2 = "2.2.17"
        val rx3 = "3.0.0-RC8"
        val reactor = "3.3.2.RELEASE"
        val reaktive = "1.1.8"
    }
}