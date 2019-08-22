plugins { `kotlin-dsl` }

buildscript {
    repositories { maven { setUrl("https://dl.bintray.com/whyoleg/kamp") } }
    dependencies { classpath("dev.whyoleg.kamp:kamp:0.1.1") }
}

kampBuild {
    val versions = BuiltInVersions(
        atomicfu = "0.12.10",
        coroutines = "1.3.0-RC2",
        kotlin = "1.3.50",
        serialization = "0.11.1",
        updates = "0.22.0",
        logging = "1.7.6"
    )
    val deps = BuiltInDependencies(versions)
    val plugins = BuiltInPlugins(deps)

    with(plugins) {
        resolvePlugins(updates, kotlinJvm, serialization, atomicfu, versioning, bintray)
    }
    dependencies(deps.kotlin.plugin.gradle)
}