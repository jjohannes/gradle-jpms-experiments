plugins {
    id("de.jjohannes.javamodules.java-library")
}

tasks.test {
    useJUnitPlatform()
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
    implementation(project(":module-b"))
    implementation(project(":module-java8"))

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    "integTestImplementation"(project(path))
    "integTestImplementation"("org.junit.jupiter:junit-jupiter-api:5.6.0")
    "integTestRuntimeOnly"("org.junit.jupiter:junit-jupiter-engine")
}
