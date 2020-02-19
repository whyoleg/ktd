plugins {
    use(Plugins.mppAndroidModule)
}

configureMultiplatform(useAndroidLibrary = true)

tasks.named<Jar>("jvmJar") {
    from(file("src/jvmMain/jniLibs")) { into("libs") }
}
