configure("ktd-raw-client") {
    source {
        main {
            api(Dependencies.kotlin.stdlib)
            compileOnly(Modules.Api.stub)
        }
    }
}
