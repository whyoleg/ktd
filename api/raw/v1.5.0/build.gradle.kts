plugins {
    use(Plugins.mppModule)
}

kotlin {
    default()
    jvm {
        dependenciesMain {
            api(Dependencies.kotlin.stdlib)
            api(ProjectModules.Client.raw)
//            compileOnly(ProjectModules.Lib.v1_5_0)
        }
    }
}
