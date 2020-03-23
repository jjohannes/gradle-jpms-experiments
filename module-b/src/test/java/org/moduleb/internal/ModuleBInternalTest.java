package org.moduleb.internal;

import org.junit.Test;
import org.moduleb.internal.ModuleBInternal;

import static org.junit.Assert.assertEquals;

public class ModuleBInternalTest {

    @Test
    public void testSomething() {
        assertEquals("org.module.b", ModuleBInternal.class.getModule().getName()); // running on module path
        assertEquals("internal text", new ModuleBInternal().print());
    }
}
