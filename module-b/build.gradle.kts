plugins {
    id("de.jjohannes.javamodules.java-library")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_9
    targetCompatibility = JavaVersion.VERSION_1_9
}

val patchArgs = listOf("--patch-module", "org.module.b=${tasks.compileJava.get().destinationDirectory.asFile.get().path}")
tasks.compileTestJava {
    options.compilerArgs = patchArgs
}
tasks.test {
    jvmArgs = patchArgs
}

val integTest: SourceSet by sourceSets.creating
val integTestTask = tasks.register<Test>("integTest") {
    testClassesDirs = integTest.output.classesDirs
    classpath = integTest.runtimeClasspath
}
tasks.check {
    dependsOn(integTestTask)
}

dependencies {
    implementation(project(":module-a"))
    testImplementation("junit:junit:4.13")
    "integTestImplementation"(project(path))
    "integTestImplementation"("junit:junit:4.13")
}