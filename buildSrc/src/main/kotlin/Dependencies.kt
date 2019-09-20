@file:Suppress("unused")

import dev.whyoleg.kamp.builtin.*
import dev.whyoleg.kamp.dependency.*
import dev.whyoleg.kamp.dependency.classifier.*
import dev.whyoleg.kamp.target.*
import dev.whyoleg.kamp.target.Target

object Dependencies : BuiltInDependencies() {
    val tdlib = LibraryDependency("src/main/libs/libtdjni.so")

    val ktd = RawDependency(
        group = "dev.whyoleg.ktd",
        name = "ktd",
        version = { Versions.ktd },
        provider = DependencyProviders.maven("https://dl.bintray.com/whyoleg/ktd")
    )(Target.jvm())
}