package org.app;

import org.modulec.ModuleC;

public class AppMain {

    public static void main(String[] args) throws Exception {
        System.out.println("Module C Name: " + ModuleC.class.getModule().getName());
        System.out.println("Module C Version: " + ModuleC.class.getModule().getDescriptor().version().get());

        System.out.println("Module Main Name: " + AppMain.class.getModule().getName());
        System.out.println("Module Main Version: " + AppMain.class.getModule().getDescriptor().version().get());
        System.out.println("Module Main Class: " + AppMain.class.getModule().getDescriptor().mainClass().get());
        try {
            // This would work with classpath, but fail at runtime with module path:
            System.out.println(Class.forName("org.modulec.internal.ModuleCInternal").getConstructor().newInstance());
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }
}
