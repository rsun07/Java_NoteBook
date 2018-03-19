package basic.io.print_and_system;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import java.io.IOException;
import java.io.InputStream;

public class SystemInTest {
    // Run as Junit Test Application blocks key board input
    @Test
//    @Ignore("Block input when build the project with maven")
    public void testReadByte() throws IOException {

        InputStream inputStream = System.in;

        byte[] data = new byte[1024];
        System.out.println("Please input: ");
        int len = inputStream.read(data);

        System.out.println("Output is: " + new String(data, 0, len));
    }

    public static void main(String[] args) throws IOException {
        JUnitCore jUnitCore = new JUnitCore();
        Result result = jUnitCore.run(SystemInTest.class);
    }
}
