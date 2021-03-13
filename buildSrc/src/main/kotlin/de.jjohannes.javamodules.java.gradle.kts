plugins {
    java
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://repo.gradle.org/gradle/ext-releases-local")
    }
}

version = "0.9-beta"

java {
    modularity.inferModulePath.set(true)
    withSourcesJar()
}

tasks.withType<JavaCompile> {
    options.release.convention(9)
}
