subprojects {
    version = "0.9-beta"

    // Will add something like this in the future to configure all tasks added by a Java plugin:
    //
    // java {
    //    modularClasspathHandling.inferModulePath.set(true)
    // }
    //
    // https://github.com/gradle/gradle/issues/12605
    tasks.withType<JavaCompile> {
        modularClasspathHandling.inferModulePath.set(true)
    }
    tasks.withType<JavaExec> {
        modularClasspathHandling.inferModulePath.set(true)
    }
    tasks.withType<Test> {
        modularClasspathHandling.inferModulePath.set(true)
    }

    repositories {
        jcenter()
    }
}
