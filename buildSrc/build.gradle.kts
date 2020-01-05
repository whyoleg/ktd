import dev.whyoleg.kamp.dependency.builder.*
import dev.whyoleg.kamp.modules.*

plugins { `kotlin-dsl` }

buildscript {
    repositories { maven { setUrl("https://dl.bintray.com/whyoleg/kamp") } }
    dependencies { classpath("dev.whyoleg.kamp:kamp:0.2.1-pre-3") }
}
kotlin.target.dependenciesMain {
    implementation(BuiltInDependencies.Stable.kamp)
    implementation(KotlinDependencies.Stable.gradlePlugin)
    implementation(KotlinDependencies.Stable.compilerEmbeddable)
    implementation(KotlinxDependencies.Stable.atomicfu.plugin)
}
