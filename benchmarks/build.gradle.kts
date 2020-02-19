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
            implementation(ProjectModules.client)
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
    configurations {
        getByName("main") {
            warmups = 5 // number of warmup iterations
            //            iterations = 5 // number of iterations
            //            iterationTime = 5 // time in seconds per iteration
        }
    }
}