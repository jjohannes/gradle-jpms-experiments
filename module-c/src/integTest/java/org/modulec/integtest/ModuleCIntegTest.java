package org.modulec.integtest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.modulec.ModuleC;

public class ModuleCIntegTest {

    @Test
    public void testModule() {
        assertEquals("org.module.c", ModuleC.class.getModule().getName());
    }
}
