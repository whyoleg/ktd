import dev.whyoleg.kamp.*
import dev.whyoleg.kamp.builtin.*

plugins { `kotlin-dsl` }

buildscript {
    repositories { mavenLocal() }
    dependencies { classpath("dev.whyoleg.kamp:kamp:0.1.0") }
}

kampBuild {
    val versions = BuiltInVersions(
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
    val deps = BuiltInDependencies(versions)
    val plugins = BuiltInPlugins(deps)

    with(plugins) {
        resolvePlugins(updates, kotlinJvm, serialization, atomicfu)
    }
    dependencies(deps.kotlin.plugin.gradle)
}