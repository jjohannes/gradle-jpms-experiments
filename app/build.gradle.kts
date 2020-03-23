plugins {
    application
}

application {
    mainModule.set("org.app")
    mainClass.set("org.app.AppMain")
}

dependencies {
    implementation(project(":module-c"))
}