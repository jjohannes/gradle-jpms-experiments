plugins {
    `java-library`
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_9
    targetCompatibility = JavaVersion.VERSION_1_9
}

dependencies {
    implementation(project(":module-with-junit4-tests"))

    testImplementation("junit:junit:4.13")
}