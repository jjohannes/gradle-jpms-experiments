plugins {
    id("org.javamodularity.moduleplugin") version "1.6.0" apply false
}

subprojects {
    apply(plugin = "org.javamodularity.moduleplugin")

    repositories {
        jcenter()
    }
}
