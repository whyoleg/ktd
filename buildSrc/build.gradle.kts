import dev.whyoleg.kamp.*
import dev.whyoleg.kamp.builtin.*

plugins { `kotlin-dsl` }

buildscript {
    repositories { maven { setUrl("https://dl.bintray.com/whyoleg/kamp") } }
    dependencies { classpath("dev.whyoleg.kamp:kamp:0.1.4") }
}

kampBuild(
    BuiltInVersions(
        atomicfu = "0.12.11",
        coroutines = "1.3.0",
        kotlin = "1.3.50",
        serialization = "0.12.0",
        updates = "0.22.0",
        logging = "1.7.6"
    )
) {
    with(BuiltInPlugins) { resolvePlugins(updates, kotlinJvm, serialization, atomicfu, versioning, bintray, buildScan) }
}