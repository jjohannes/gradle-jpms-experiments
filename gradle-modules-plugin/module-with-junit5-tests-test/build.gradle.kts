plugins {
    `java-library`
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_9
    targetCompatibility = JavaVersion.VERSION_1_9
}

dependencies {
    implementation(project(":module-with-junit5-tests"))

    implementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    runtimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
}

tasks.test {
    useJUnitPlatform()
}