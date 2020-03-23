package org.app;

import org.modulea.ModuleA;

public class AppMain {

    public static void main(String[] args) throws Exception {
        System.out.println(new ModuleA());
        // This will work with classpath, but fail at runtime with module path:
        System.out.println(Class.forName("org.modulea.internal.ModuleAInternal").getConstructor().newInstance());
    }
}
