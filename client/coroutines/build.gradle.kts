import dev.whyoleg.kamp.modules.*
import org.jetbrains.kotlin.config.*

plugins {
    use(Plugins.mppModule + Plugins.atomicfuModule)
}

kotlin {
    default()
    jvm {
        dependenciesMain {
            api(Dependencies.kotlin.stdlib)
            api(Dependencies.kotlinx.coroutines.core)
            api(Dependencies.kotlinx.atomicfu.atomicfu)
            api(Dependencies.kotlinx.immutableCollections)
            api(ProjectModules.Client.raw)
            compileOnly(ProjectModules.Api.stub)
        }
    }
}
