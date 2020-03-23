package example.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.modulea.ModuleA;

public class ModuleATest {

    @Test
    public void testModule() {
        assertEquals("org.module.a", ModuleA.class.getModule().getName());
        //assertEquals("org.module.b", ModuleB.class.getModule().getName());
    }
}
