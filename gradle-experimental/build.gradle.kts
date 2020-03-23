subprojects {
    tasks.withType<JavaCompile> {
        modulePathHandling = ModulePathHandling.INFER_MODULE_PATH
        options.isFork = true
        options.isIncremental = false // not fully supported by spike
    }
    tasks.withType<JavaExec> {
        modulePathHandling = ModulePathHandling.INFER_MODULE_PATH
    }
    tasks.withType<Test> {
        modulePathHandling = ModulePathHandling.INFER_MODULE_PATH
    }

    repositories {
        jcenter()
    }
}
