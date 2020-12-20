import dev.whyoleg.kamp.dependency.*
import org.gradle.api.*

fun Project.configureApi(serialization: Boolean, vararg modules: KampModule) {
    configureMultiplatform {
        kampCommonMain.dependencies { modules via ::api }

        jsonTargets {
            dependenciesMain {
                api(Dependencies.kotlin.stdlib)
                if (serialization) api(Dependencies.kotlinx.serialization)
            }
        }

        withAndroid()
    }
}
