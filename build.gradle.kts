plugins {
    `java-base`
}

subprojects {
    apply(plugin = "java")
    version = "0.9-beta"

    java {
        modularClasspathHandling.inferModulePath.set(true)
        release.set(9)
        withJavadocJar()
        withSourcesJar()
    }

    repositories {
        jcenter()
    }
}
