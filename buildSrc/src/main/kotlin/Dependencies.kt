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
}
