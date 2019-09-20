kampJvm {
    source {
        main {
            implementation {
                +Dependencies.kotlin.stdlib
                +Dependencies.coroutines.core
//                +Dependencies.ktd
                +Modules.library
            }
        }
    }
}
