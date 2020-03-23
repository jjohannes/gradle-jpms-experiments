package example.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.moduleb.ModuleB;

public class ModuleBTest {

    @Test
    public void testModule() {
        assertEquals("org.module.b", ModuleB.class.getModule().getName());
        //assertEquals("org.module.b", ModuleB.class.getModule().getName());
    }
}
