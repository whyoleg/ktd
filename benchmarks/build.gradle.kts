plugins {
    use(Plugins.mppModule + Plugins.benchmarks)
}

configureMultiplatform(publishable = false)

kotlin {
    dependenciesMain {
        implementation(Dependencies.kotlin.stdlib)
        implementation(Dependencies.kotlinx.coroutines.core)
        implementation(Dependencies.benchmarks)
    }
    metadata {
        dependenciesMain {
            implementation(ProjectModules.Clients.client_suspend)
            implementation(ProjectModules.Api.api_test)
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