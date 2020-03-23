package org.app;

import org.modulec.ModuleC;

public class AppMain {

    public static void main(String[] args) throws Exception {
        System.out.println(new ModuleC());
        try {
            // This would work with classpath, but fail at runtime with module path:
            System.out.println(Class.forName("org.modulec.internal.ModuleCInternal").getConstructor().newInstance());
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }
}
