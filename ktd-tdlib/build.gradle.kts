plugins {
    use(Plugins.mppAndroidModule)
}

configureMultiplatform(android = true)
configureTdlibPublishing()

tasks.named<Jar>("jvmJar") {
    from(file("src/jvmMain/jniLibs")) { into("libs") }
}
