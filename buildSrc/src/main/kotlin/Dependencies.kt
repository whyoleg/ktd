@file:Suppress("unused")

import dev.whyoleg.kamp.dependency.*
import dev.whyoleg.kamp.dependency.classifier.*
import dev.whyoleg.kamp.target.*

object Dependencies : BuiltInDependencies() {
    val immutableCollections = kotlinx.dependency(
        name = "kotlinx-collections-immutable",
        version = { Versions.immutableCollections },
        target = jvm("jvm"),
        provider = DependencyProviders.maven("https://kotlin.bintray.com/kotlinx") //TODO move it to kamp
    )

    val cli = kotlinx.dependency(
        name = "kotlinx-cli",
        version = { Versions.cli },
        target = jvm("jvm"),
        provider = DependencyProviders.maven("https://dl.bintray.com/kotlin/kotlin-dev")
    )

    val githubApi = RawDependency(
        group = "org.kohsuke",
        name = "github-api",
        version = { Versions.githubApi },
        provider = DependencyProviders.mavenCentral
    )(jvm())

    val kotlinShell = RawDependency(
        group = "eu.jrie.jetbrains",
        name = "kotlin-shell-core",
        version = { Versions.kotlinShell },
        provider = DependencyProviders.maven("https://dl.bintray.com/jakubriegel/kotlin-shell")
    )(jvm())

    val dotenv = RawDependency(
        group = "io.github.cdimascio",
        name = "java-dotenv",
        version = { Versions.dotenv },
        provider = DependencyProviders.mavenCentral
    )(jvm())
}
