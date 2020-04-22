plugins {
    `java-base`
}

subprojects {
    apply(plugin = "java")
    version = "0.9-beta"

    java {
        modularity.inferModulePath.set(true)
        withSourcesJar()
    }

    tasks.withType<JavaCompile> {
        options.compilerArgs.addAll(listOf("--release", "9"))
    }

    repositories {
        jcenter()
    }
}
