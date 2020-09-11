plugins {
    java
}

repositories {
    jcenter()
}

version = "0.9-beta"

java {
    modularity.inferModulePath.set(true)
    withSourcesJar()
}

tasks.withType<JavaCompile> {
    options.release.convention(9)
}
