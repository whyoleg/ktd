allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}

createBintrayPublishTask(ktdPublisher)
createBintrayPublishTask(libPublisher)
