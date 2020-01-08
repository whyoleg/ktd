plugins {
    use(Plugins.mppModule)
}

android {
    default()

    sourceSets {
        val main by getting {
            jniLibs.srcDir("src/androidMain/jniLibs")
        }
    }
}

kotlin {
    configureMultiplatform()
}

tasks.named<Jar>("jvmJar") {
    from(file("src/jvmMain/jniLibs")) {
        into("libs")
    }
}
