plugins {
    id("com.github.ben-manes.versions")
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}

tasks.create("unitTests") {
    description = "Runs all unit tests in project"
    group = "verification"
    getTasksByName("jvmTest", true).forEach {
        if (
            it.project.name != "benchmarks" &&
            !it.project.name.startsWith("api-") &&
            it.project.parent?.parent?.name?.startsWith("migration") != true
        ) dependsOn(it)
    }
}
