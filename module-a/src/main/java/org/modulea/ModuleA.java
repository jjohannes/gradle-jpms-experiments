package org.modulea;

import net.rubygrapefruit.platform.Native;

import java.io.File;

public class ModuleA {

    public void doSomething() {
        Native.init(new File("."));
    }
}
