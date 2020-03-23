package org.moduleb.internal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ModuleBInternalClasspathTest {

    @Test
    public void testSomething() {
        assertNull(ModuleBInternal.class.getModule().getName()); // running on classpath
        assertEquals("text", new ModuleBInternal().print());
    }
}
