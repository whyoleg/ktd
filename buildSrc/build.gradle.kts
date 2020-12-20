buildscript {
    repositories {
        maven("https://dl.bintray.com/whyoleg/kamp")
    }
    dependencies {
        classpath("dev.whyoleg.kamp:kamp-build:0.3.0.beta.1")
    }
}

plugins {
    `kotlin-dsl`
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

repositories {
    maven("https://dl.bintray.com/whyoleg/kamp")
    mavenCentral()
    google()
    jcenter()
}

kampBuild {
    publication = true
    features {
        android = true
        kotlin = true
        kotlinx = true
        ktor = true
        gradle = true
        shadow = true
        updates = true
    }
}

dependencies {
    implementation("com.android.tools.build:gradle:3.6.0")
}
