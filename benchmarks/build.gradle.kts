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
            implementation(ProjectModules.api)
            implementation(ProjectModules.Clients.client_deferred)
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
    configurations {
        getByName("main") {
            warmups = 3 // number of warmup iterations
            //            iterations = 5 // number of iterations
            //            iterationTime = 5 // time in seconds per iteration
        }
    }
}