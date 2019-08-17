kampJvmCommon {
    plugins(Plugins.atomicfu)
    source {
        main {
            implementation {
                +Dependencies.kotlin.stdlib
                +Dependencies.kotlinx.atomicfu
                +Dependencies.logging.logging
                +Dependencies.coroutines.core
                +Dependencies.tdlib
            }
        }
    }
}