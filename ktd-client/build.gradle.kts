plugins {
    ids(Plugins.core)
}

configureMultiplatform {
    dependenciesMain {
        api(Dependencies.kotlin.stdlib)
        compileOnly(Dependencies.atomicfuMetadata)
    }
    jsonTargets {
        dependenciesMain {
            api(Dependencies.kotlinx.serialization)
        }
    }
}
//configurePublishing("core")
