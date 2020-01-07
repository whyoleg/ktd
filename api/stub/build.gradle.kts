plugins {
    use(Plugins.mppModule)
}

android { default() }

kotlin {
    default(project)
    dependenciesMain {
        api(Dependencies.kotlin.stdlib)
    }
}
