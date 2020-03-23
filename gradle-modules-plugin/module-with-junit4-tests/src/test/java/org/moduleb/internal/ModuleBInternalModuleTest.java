package org.moduleb.internal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ModuleBInternalModuleTest {

    @Test
    public void testSomething() {
        assertEquals("org.module.b", ModuleBInternal.class.getModule().getName()); // running on module path
        assertEquals("text", new ModuleBInternal().print());
    }
}
