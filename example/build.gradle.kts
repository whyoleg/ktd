configuredKamp {
    source {
        main {
            implementation {
                +Dependencies.kotlin.stdlib
                +Dependencies.coroutines.core
                +Modules.library
            }
        }
    }
}
