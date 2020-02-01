import dev.whyoleg.kamp.modules.*

object Plugins {
    val mppModule = listOf(KotlinPlugins.Stable.kotlinMpp, GradleBuiltInPlugins.mavenPublish)
    val mppAndroidModule = mppModule + BuiltInPlugins.Stable.androidLib
    val exampleModule = listOf(KotlinPlugins.Stable.kotlinMpp)
    val atomicfuModule = listOf(KotlinxPlugins.Stable.atomicfu)
    val cliModule = listOf(
        KotlinPlugins.Stable.kotlinJvm,
        KotlinPlugins.Stable.serialization,
        BuiltInPlugins.Stable.shadow,
        GradleBuiltInPlugins.application,
        GradleBuiltInPlugins.mavenPublish
    )

    val serializationModule = listOf(KotlinPlugins.Stable.serialization)
}
