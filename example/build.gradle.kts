configure {
    source {
        main {
            implementation {
                +Dependencies.kotlin.stdlib
                +Dependencies.coroutines.core
                +Modules.Api.latest.coroutines
            }
        }
    }
}
