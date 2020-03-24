plugins { `kotlin-dsl` }

repositories {
    maven("https://dl.bintray.com/whyoleg/kamp")
    mavenCentral()
    google()
    jcenter()
}

dependencies {
    implementation("dev.whyoleg.kamp:kamp:0.2.1-pre-5")
    implementation("com.android.tools.build:gradle:3.5.3")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.70")
    implementation("org.jetbrains.kotlin:kotlin-compiler-embeddable:1.3.70")
}
