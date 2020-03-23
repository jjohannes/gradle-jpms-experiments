package org.modulea;

import org.modulea.internal.ModuleAInternal;
import org.moduleb.ModuleB;
// import org.moduleb.internal.ModuleBInternal;

public class ModuleA {
    private ModuleAInternal internal = new ModuleAInternal();
    private ModuleB mb = new ModuleB();
    // private ModuleBInternal mbi = new ModuleBInternal();
}
