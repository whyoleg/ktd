kampJvmCommon {
    plugins(Plugins.atomicfu)
    source {
        main {
            implementation {
                +Dependencies.kotlin.stdlib
                +Dependencies.coroutines.core
                +Dependencies.tdlib
            }
        }
    }
}