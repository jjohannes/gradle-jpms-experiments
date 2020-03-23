plugins {
    `java-library`
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

val main: SourceSet by sourceSets.getting

// === This code is copied from Gradle code base, we need a public API for all this setup: adding a new directory set with compile task
// === https://github.com/gradle/gradle/issues/727
val java9 = objects.sourceDirectorySet("java9", "Java 9 Sources")
java9.srcDir("src/" + main.name + "/" + java9.name)
main.allJava.source(java9)
main.allSource.source(java9)
val sourceSetChildPath = "classes/" + java9.name + "/" + main.name
java9.destinationDirectory.convention(layout.buildDirectory.dir(sourceSetChildPath))
val compileJava9 = tasks.register<JavaCompile>("compileJava9") {
    sourceCompatibility = JavaVersion.VERSION_1_9.toString()
    targetCompatibility = JavaVersion.VERSION_1_9.toString()

    source = java9
    classpath = main.compileClasspath

    println(main.java.outputDir.path)
    options.compilerArgs.addAll(listOf(
            "--release", "9",
            "--patch-module", "org.java8compatible=${main.java.outputDir.path}" // so we can compile to another location
    ))
}
var sourceSetOutput = main.output as org.gradle.api.internal.tasks.DefaultSourceSetOutput
sourceSetOutput.addClassesDir { java9.destinationDirectory.asFile.get() }
sourceSetOutput.registerCompileTask(compileJava9)
java9.compiledBy(compileJava9, AbstractCompile::getDestinationDirectory)
tasks.classes {
    dependsOn(compileJava9)
}
// ===
