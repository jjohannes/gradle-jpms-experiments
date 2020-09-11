plugins {
    id("de.jjohannes.javamodules.java-library")
    kotlin("jvm") version "1.4.0"
}

tasks.compileJava {
    // this is needed because we have a separate compile step in this example with the 'module-info.java' is in 'main/java' and the Kotlin code is in 'main/kotlin'
    options.compilerArgs = listOf("--patch-module", "org.module.kotlin=${sourceSets.main.get().output.asPath}")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.google.code.gson:gson:2.8.6")
}

// == Integration test setup: you can put this into a buildSrc plugin
val integTest: SourceSet by sourceSets.creating
val integTestJarTask = tasks.register<Jar>(integTest.jarTaskName) {
    archiveClassifier.set("integration-tests")
    from(integTest.output)
}
val integTestTask = tasks.register<Test>("integTest") {
    testClassesDirs = integTest.output.classesDirs
    // Make sure we run the 'Jar' containing the tests (and not just the 'classes' folder) so that test resources are also part of the test module
    classpath = configurations[integTest.runtimeClasspathConfigurationName] + files(integTestJarTask)
}
dependencies {
    "integTestImplementation"(project)
    "integTestImplementation"("junit:junit:4.13")
}
tasks.check { dependsOn(integTestTask) }

