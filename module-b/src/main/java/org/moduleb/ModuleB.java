package org.moduleb;

import org.modulea.ModuleA;
import org.moduleb.internal.ModuleBInternal;

public class ModuleB {
    private ModuleBInternal internal = new ModuleBInternal();
    private ModuleA moduleA = new ModuleA();

    protected String print() {
        String text = "text";
        System.out.println(text);
        return text;
    }
}
