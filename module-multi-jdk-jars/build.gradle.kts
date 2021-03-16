plugins {
    id("de.jjohannes.javamodules.java-library")
}

val java8 = sourceSets.create("java8")
val java11 = sourceSets.create("java11")
val java15 = sourceSets.create("java15") // 15 is the 'main' variant (Jar without classifier)

java {
    registerFeature("java8") {
        usingSourceSet(java8)
        capability(project.group.toString(), project.name, project.version.toString())
    }
    registerFeature("java11") {
        usingSourceSet(java11)
        capability(project.group.toString(), project.name, project.version.toString())
    }
}

configureCompileTask(java8, java8.compileJavaTaskName, 8)
configureCompileTask(java11, java11.compileJavaTaskName, 11)
configureCompileTask(java15, sourceSets.main.get().compileJavaTaskName, 15)

fun configureCompileTask(sourceSet: SourceSet, compileTaskName: String, javaVersion: Int) {
    tasks.named<JavaCompile>(compileTaskName) {
        javaCompiler.set(javaToolchains.compilerFor {
            languageVersion.set(JavaLanguageVersion.of(javaVersion))
        })
        source = sourceSets.main.get().allJava + sourceSet.allJava
    }
}
