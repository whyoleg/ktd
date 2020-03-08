import dev.whyoleg.kamp.dependency.*
import dev.whyoleg.kamp.platform.*
import org.jetbrains.kotlin.gradle.dsl.*

inline fun KotlinMultiplatformExtension.dependencies(compilation: String, crossinline configure: KampDependencyHandler.() -> Unit) {
    targets.all {
        compilations.findByName(compilation)?.defaultSourceSet?.dependencies(platformType, configure)
    }
}

inline fun KotlinMultiplatformExtension.dependenciesMain(crossinline configure: KampDependencyHandler.() -> Unit) {
    dependencies("main", configure)
}

inline fun KotlinMultiplatformExtension.dependenciesTest(crossinline configure: KampDependencyHandler.() -> Unit) {
    dependencies("test", configure)
    sourceSets.getByName("commonTest") { dependencies(KampPlatform.common, configure) }
}

inline fun KotlinMultiplatformExtension.metadataDependenciesTest(crossinline configure: KampDependencyHandler.() -> Unit) {
    sourceSets.getByName("commonTest") { dependencies(KampPlatform.common, configure) }
}
