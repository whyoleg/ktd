@file:Suppress("unused")

import dev.whyoleg.kamp.dependency.*
import dev.whyoleg.kamp.dependency.classifier.*
import dev.whyoleg.kamp.target.*

object Dependencies : BuiltInDependencies() {
    val tdlib = LibraryDependency("src/main/libs/libtdjni.so")

    val immutableCollections = kotlinx.dependency(
        name = "kotlinx-collections-immutable",
        version = { Versions.immutableCollections },
        target = jvm("jvm")
    )
}
