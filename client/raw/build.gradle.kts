configure("ktd-raw-client") {
    source {
        main {
            api(Dependencies.kotlin.stdlib)
            compileOnly(Modules.Api.stub)
        }
        test {
            implementation(Dependencies.kotlin.test)
            implementation(Dependencies.kotlin.annotations)
            implementation(Modules.Api.latest.raw)
        }
    }
}
