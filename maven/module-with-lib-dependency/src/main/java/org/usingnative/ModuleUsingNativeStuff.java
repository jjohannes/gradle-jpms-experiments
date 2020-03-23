package org.usingnative;

import net.rubygrapefruit.platform.Native;

import java.io.File;

public class ModuleUsingNativeStuff {

    public void doSomething() {
        Native.init(new File("."));
    }
}
