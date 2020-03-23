plugins {
    application
}

application {
    mainClassName = "org.app/org.app.AppMain" // <- class in module will trigger using the --module-path
    // mainClassName = "org.app.AppMain"
}

dependencies {
    implementation(project(":module-with-junit5-tests"))
}