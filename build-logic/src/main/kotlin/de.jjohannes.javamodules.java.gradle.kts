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
group = "de.jjohannes.javamodules.gradle-jpms-experiments"

java {
    withSourcesJar()
    toolchain.languageVersion.convention(JavaLanguageVersion.of(9))
}
