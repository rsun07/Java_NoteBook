package basic.io.byte_stream;

import basic.io.Utils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamTest {
    private static File file;
    private static InputStream inputStream;

    @BeforeClass
    public static void init() {
        File fileInit = new File(Utils.FILE_PATH + Utils.INPUT_FILE_NAME);

        if (fileInit.exists()) {
            file = fileInit;
        }
    }

    @Before
    public void setUp() throws FileNotFoundException {
        inputStream = new FileInputStream(file);
    }

    @After
    public void tearDown() throws IOException {
        inputStream.close();
    }

    @Test
    public void testReadByByteArray() throws IOException {
        byte[] data = new byte[256];
        int numOfBytes = inputStream.read(data);

        assertAndOutput(numOfBytes, data);
    }


    // Recommended
    @Test
    public void testOutputPartialData() throws IOException {
        byte[] data = new byte[256];
        int temp = 0;
        int index = 0;

        while( (temp = inputStream.read()) != -1) {
            data[index++] = (byte) temp;
        }

        assertAndOutput(index, data);
    }

    // Rarely used in practice
    @Test
    public void testReadByByteDoWhile() throws IOException {
        byte[] data = new byte[256];
        int temp = 0;
        int index = 0;

        do {
            temp = inputStream.read();
            if (temp != -1) {
                data[index++] = (byte) temp;
            }
        } while (temp != -1);

        assertAndOutput(index, data);
    }

    private void assertAndOutput(int length, byte[] data) {
        Assert.assertEquals(236, length);
        System.out.println(length);

        System.out.println("{\n" + new String(data, 0 , length) + "\n}");
    }
}
