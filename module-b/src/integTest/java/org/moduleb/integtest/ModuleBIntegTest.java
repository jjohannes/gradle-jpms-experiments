package org.moduleb.integtest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.moduleb.ModuleB;

public class ModuleBIntegTest {

    @Test
    public void testModule() {
        assertEquals("org.module.b", ModuleB.class.getModule().getName());
        assertEquals("org.module.b.integtest", this.getClass().getModule().getName());
    }
}
