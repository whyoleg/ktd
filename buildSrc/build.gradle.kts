import dev.whyoleg.kamp.*
import dev.whyoleg.kamp.plugin.*

plugins { `kotlin-dsl` }

buildscript {
    repositories { maven { setUrl("https://dl.bintray.com/whyoleg/kamp") } }
    dependencies { classpath("dev.whyoleg.kamp:kamp:0.1.16") }
}

kampBuild {
    with(BuiltInPlugins) { resolvePlugins(updates, kotlinJvm, serialization, atomicfu, bintray, buildScan, shadow) }
}
