plugins {
    id("de.jjohannes.javamodules.java-library")
    kotlin("jvm") version "1.3.72"
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

// == Add access to the 'modular' variant of kotlin("stdlib"): Put this into a buildSrc plugin and reuse it in all your subprojects
configurations.all {
    if (name.toLowerCase().endsWith("compileclasspath") || name.toLowerCase().endsWith("runtimeclasspath")) {
        attributes.attribute(LibraryElements.LIBRARY_ELEMENTS_ATTRIBUTE, objects.named("modular-jar"))
    }
    if (name.toLowerCase().endsWith("compile") || name.toLowerCase().endsWith("runtime")) {
        isCanBeConsumed = false
    }
}
dependencies {
    attributesSchema.attribute(LibraryElements.LIBRARY_ELEMENTS_ATTRIBUTE).compatibilityRules.add(ModularJarCompatibilityRule::class)
    components { withModule<ModularKotlinRule>(kotlin("stdlib")) }
}
abstract class ModularJarCompatibilityRule : AttributeCompatibilityRule<LibraryElements> {
    override fun execute(details: CompatibilityCheckDetails<LibraryElements>) : Unit = details.run {
        if (producerValue?.name == LibraryElements.JAR && consumerValue?.name == "modular-jar") {
            compatible()
        }
    }
}
abstract class ModularKotlinRule : ComponentMetadataRule {

    @javax.inject.Inject
    abstract fun getObjects(): ObjectFactory

    override fun execute(ctx: ComponentMetadataContext) {
        val id = ctx.details.id
        listOf("compile", "runtime").forEach { baseVariant ->
            ctx.details.addVariant("${baseVariant}Modular", baseVariant) {
                attributes {
                    attribute(LibraryElements.LIBRARY_ELEMENTS_ATTRIBUTE, getObjects().named("modular-jar"))
                }
                withFiles {
                    removeAllFiles()
                    addFile("${id.name}-${id.version}-modular.jar")
                }
                withDependencies {
                    clear() // 'kotlin-stdlib-common' and  'annotations' are not modules and are also not needed
                }
            }
        }
    }
}
