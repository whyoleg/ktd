plugins {
    ids(Plugins.mppWithAndroid)
}

configureMultiplatform {
    defaultTargets()
}
//configureTdlibPublishing()

tasks.named<Jar>("jvmJar") {
    from(file("src/jvmMain/jniLibs")) { into("libs") }
}
