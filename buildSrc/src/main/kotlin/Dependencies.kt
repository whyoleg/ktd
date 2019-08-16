@file:Suppress("unused")

import dev.whyoleg.kamp.builtin.*
import dev.whyoleg.kamp.dependency.*

object Dependencies : BuiltInDependencies(Versions.builtIn) {
    val tdlib = LibraryDependency("src/main/libs/libtdjni.so")
}