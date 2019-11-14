configure {
    with(Plugins) {
        plugins(atomicfu)
    }
    source {
        main {
            implementation(Dependencies.kotlinx.atomicfu)
            api {
                +Dependencies.kotlin.stdlib
                +Dependencies.coroutines.core
                +Dependencies.immutableCollections
            }
            compileOnly(Modules.Api.stub)
        }
    }
}
