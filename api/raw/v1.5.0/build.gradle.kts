plugins {
    use(Plugins.mppModule)
}

android { default() }

kotlin {
    default(project)
    dependenciesMain {
        api(Dependencies.kotlin.stdlib)
        //            compileOnly(ProjectModules.Lib.v1_5_0)
    }
}
