@file:Suppress("unused")

import dev.whyoleg.kamp.dependency.*
import dev.whyoleg.kamp.dependency.classifier.*
import dev.whyoleg.kamp.target.*

object Dependencies : BuiltInDependencies() {
    val tdlib = LibraryDependency("src/main/libs/libtdjni.so")

    val immutableCollections = kotlinx.dependency(
        name = "kotlinx-collections-immutable",
        version = { Versions.immutableCollections },
        target = jvm("jvm"),
        provider = DependencyProviders.maven("https://kotlin.bintray.com/kotlinx") //TODO move it to kamp
    )

    val githubApi = RawDependency("org.kohsuke", "github-api", { Versions.githubApi }, DependencyProviders.mavenCentral)(jvm())
    val kotlinShell = RawDependency(
        "ru.krikun.kotlin",
        "kotlin-shell",
        { Versions.kotlinShell },
        DependencyProviders.maven("https://dl.bintray.com/olegkrikun/maven")
    )(jvm())
}
