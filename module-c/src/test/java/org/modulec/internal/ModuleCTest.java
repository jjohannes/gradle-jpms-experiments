package org.modulec.internal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.moduleb.internal.ModuleBInternal;

public class ModuleCTest {

    @Test
    public void testModule() {
        assertNull(ModuleBInternal.class.getModule().getName()); // running on classpath
        assertEquals("internal text", new ModuleCInternal().print());
    }
}
