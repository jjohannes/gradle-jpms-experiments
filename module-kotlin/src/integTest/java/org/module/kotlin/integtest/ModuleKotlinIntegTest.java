package org.module.kotlin.integtest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.module.kotlin.KotlinModule;

public class ModuleKotlinIntegTest {

    @Test
    public void testModule() {
        assertEquals("org.module.kotlin", KotlinModule.class.getModule().getName());
        assertEquals("org.module.kotlin.integtest", this.getClass().getModule().getName());
    }
}
