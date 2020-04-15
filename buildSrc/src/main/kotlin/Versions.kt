import dev.whyoleg.kamp.modules.*

object Versions {
    val kotlin = KotlinVersion("1.3.72")

    val kotlinx = KotlinxVersions.Stable.copy(
        atomicfu = "0.14.3",
        immutableCollections = "0.3.2",
        benchmark = "0.2.0-dev-7"
    )

    val ktor = KtorVersion.Stable

    const val githubApi = "1.110"
    const val kotlinShell = "0.2.1"
    const val kotlinPoet = "1.5.0"

    const val ktdVersion = "0.6.0-pre-1"

    object Reactive {
        val rx2 = "2.2.17"
        val rx3 = "3.0.0-RC8"
        val reactor = "3.3.2.RELEASE"
        val reaktive = "1.1.8"
    }
}
