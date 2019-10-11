@file:Suppress("unused")

import dev.whyoleg.kamp.dependency.*

object Dependencies : BuiltInDependencies() {
    val tdlib = LibraryDependency("src/main/libs/libtdjni.so")
}
