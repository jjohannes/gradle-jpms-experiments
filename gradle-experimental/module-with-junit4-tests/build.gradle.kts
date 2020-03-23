plugins {
    `java-library`
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_9
    targetCompatibility = JavaVersion.VERSION_1_9
}

val whiteboxClasspathTest: SourceSet by sourceSets.creating
val whiteboxModuleTest: SourceSet by sourceSets.creating
val whiteboxClasspathTestTask = tasks.register<Test>("whiteboxClasspathTest") {
    testClassesDirs = whiteboxClasspathTest.output.classesDirs
    classpath = whiteboxClasspathTest.runtimeClasspath
}
val whiteboxModuleTestTask = tasks.register<Test>("whiteboxModuleTest") {
    testClassesDirs = whiteboxModuleTest.output.classesDirs
    classpath = whiteboxModuleTest.runtimeClasspath
}

tasks.check {
    dependsOn(whiteboxClasspathTestTask)
    // dependsOn(whiteboxModuleTestTask)
}

dependencies {
    testImplementation("junit:junit:4.13")
    "whiteboxClasspathTestImplementation"(project(path))
    "whiteboxClasspathTestImplementation"("junit:junit:4.13")
    "whiteboxModuleTestImplementation"(project(path))
    "whiteboxModuleTestImplementation"("junit:junit:4.13")
}