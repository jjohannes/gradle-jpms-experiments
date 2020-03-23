package org.modulec;

import org.moduleb.ModuleB;
import org.modulec.internal.ModuleCInternal;

public class ModuleC {
    private ModuleCInternal internal = new ModuleCInternal();
    private ModuleB mb = new ModuleB();
}
