import dev.whyoleg.kamp.dependency.*
import dev.whyoleg.kamp.dependency.builder.*
import dev.whyoleg.kamp.modules.*

object Dependencies {
    val kotlin = KotlinModule(KotlinVersion(Versions.kotlin)).dependencies
    val kotlinx = KotlinxModule(KotlinxVersions.Stable).dependencies
    val ktor = KtorDependencies.Stable

    val githubApi =
        group("org.kohsuke", RepositoryProviders.mavenCentral)
            .artifact("github-api").version(Versions.githubApi).jvm
    val kotlinShell =
        group("eu.jrie.jetbrains", RepositoryProviders.bintray("jakubriegel", "kotlin-shell"), KotlinModule.EapProvider)
            .artifact("kotlin-shell-core").version(Versions.kotlinShell).jvm


    fun ktdApiCoroutines(tdVersion: String) =
        group("dev.whyoleg.ktd", RepositoryProviders.mavenLocal)
            .artifact("ktd-api-coroutines").version("${Versions.ktdVersion}-$tdVersion").common

    object Reactive {
        val rx2 =
            group("io.reactivex.rxjava2", RepositoryProviders.mavenCentral)
                .artifact("rxjava").version(Versions.Reactive.rx2).jvm
        val rx3 =
            group("io.reactivex.rxjava3", RepositoryProviders.mavenCentral)
                .artifact("rxjava").version(Versions.Reactive.rx3).jvm
        val reactor =
            group("io.projectreactor", RepositoryProviders.mavenCentral)
                .artifact("reactor-core").version(Versions.Reactive.reactor).jvm
        val reaktive =
            group("com.badoo.reaktive", RepositoryProviders.bintray("badoo", "maven"))
                .artifact("reaktive").version(Versions.Reactive.reaktive).common
    }
}
