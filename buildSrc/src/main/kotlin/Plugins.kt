import dev.whyoleg.kamp.feature.kotlin.*
import dev.whyoleg.kamp.feature.kotlinx.*
import dev.whyoleg.kamp.feature.shadow.*
import dev.whyoleg.kamp.feature.gradle.*
import dev.whyoleg.kamp.feature.android.*

object Plugins {
    val cli = listOf(
        KotlinPlugins.jvm,
        KotlinPlugins.serialization,
        GradlePlugins.application,
        GradlePlugins.mavenPublish,
        Shadow.plugin
    )

    val mpp = listOf(KotlinPlugins.multiplatform, GradlePlugins.mavenPublish)
    val mppWithAndroid = mpp + AndroidPlugins.library
    val mppWithAndroidAndSerialization = mppWithAndroid + KotlinPlugins.serialization

    val mppWithAtomic = mpp + KotlinxPlugins.atomicfu
    val core = mppWithAtomic + KotlinPlugins.serialization

    val benchmarks = mpp + KotlinxPlugins.benchmark + KotlinPlugins.allOpen
}
