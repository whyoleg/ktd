import dev.whyoleg.kamp.dependency.*
import dev.whyoleg.kamp.feature.kotlin.*
import dev.whyoleg.kamp.feature.kotlinx.*
import dev.whyoleg.kamp.feature.ktor.*

object Dependencies {
    val kotlin = Kotlin.dependencies(KampVersions.kotlin)
    val kotlinx = Kotlinx.dependencies(
        KotlinxVersions(
            coroutines = KampVersions.Kotlinx.coroutines,
            serialization = KampVersions.Kotlinx.serialization,
            atomicfu = KampVersions.Kotlinx.atomicfu,
            cli = KampVersions.Kotlinx.cli,
            immutableCollections = KampVersions.Kotlinx.immutableCollections,
            benchmark = KampVersions.Kotlinx.benchmark
        )
    )
    val atomicfuMetadata = kotlinx.atomicfu.platforms(KampPlatform.common)

    val ktor = Ktor.dependencies()

    val githubApi = dependency("org.kohsuke", "github-api", KampVersions.githubApi, KampPlatform.jvm)
    val kotlinShell = dependency("eu.jrie.jetbrains", "kotlin-shell-core", KampVersions.kotlinShell, KampPlatform.jvm)
    val kotlinPoet = dependency("com.squareup", "kotlinpoet", KampVersions.kotlinPoet, KampPlatform.jvm)

}
//
//    fun ktdApiTest(tdVersion: String) =
//        group("dev.whyoleg.ktd", RepositoryProviders.mavenLocal)
//            .artifact("ktd-api-test").version("${Versions.ktdVersion}-$tdVersion").common
//
