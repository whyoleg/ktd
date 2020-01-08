import dev.whyoleg.kamp.dependency.*
import dev.whyoleg.kamp.platform.*
import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.dsl.*

inline fun KotlinMultiplatformExtension.dependencies(compilation: String, crossinline configure: KampDependencyHandler.() -> Unit) {
    targets.all {
        compilations.findByName(compilation)?.defaultSourceSet?.dependencies(platformType, configure)
    }
    sourceSets["android" + compilation.capitalize()].dependencies(KampPlatform.android, configure)
}

inline fun KotlinMultiplatformExtension.dependenciesMain(crossinline configure: KampDependencyHandler.() -> Unit) {
    dependencies("main", configure)
}

inline fun KotlinMultiplatformExtension.dependenciesTest(crossinline configure: KampDependencyHandler.() -> Unit) {
    dependencies("test", configure)
}
