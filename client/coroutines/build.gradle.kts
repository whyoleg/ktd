configure("coroutines-client") {
    plugins(Plugins.atomicfu)
    source {
        main {
            implementation(Dependencies.kotlinx.atomicfu)
            api {
                +Dependencies.kotlin.stdlib
                +Dependencies.coroutines.core
                +Dependencies.immutableCollections
                +Modules.Client.raw
            }
            compileOnly(Modules.Api.stub)
        }
    }
}
