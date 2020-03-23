plugins {
    use(Plugins.mppModule + Plugins.benchmarks)
}

configureMultiplatform(publishable = false)

kotlin {
    dependenciesMain {
        implementation(Dependencies.kotlin.stdlib)
        implementation(Dependencies.kotlinx.coroutines.core)
        implementation(Dependencies.kotlinx.benchmark.metadata)
    }
    metadata {
        dependenciesMain {
            implementation(ProjectModules.Client.clientSuspend)
            implementation(ProjectModules.Api.apiTest)
        }
    }
}

allOpen {
    annotation("org.openjdk.jmh.annotations.State")
}

benchmark {
    targets {
        register("jvm")
    }
}
