package org.moduleb;

import org.junit.Test;
import org.moduleb.ModuleB;

import static org.junit.Assert.assertEquals;

public class ModuleBTest {

    @Test
    public void testSomething() {
        assertEquals("org.module.b", ModuleB.class.getModule().getName()); // running on module path
        assertEquals("text", new ModuleB().print());
    }
}
