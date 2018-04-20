package pers.xiaoming.notebook.io.io.memory_stream;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StringManipulatorTest {
    @Test
    public void testToUpperCase() throws IOException {
        String result = StringManipulator.toUpperCase("Hello*World!!!");

        Assert.assertEquals("HELLO*WORLD!!!", result);
    }
}
