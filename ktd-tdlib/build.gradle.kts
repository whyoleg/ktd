plugins {
    use(Plugins.mppModule)
}

configureMultiplatform()

tasks.named<Jar>("jvmJar") {
    from(file("src/jvmMain/jniLibs")) { into("libs") }
}
