package pers.xiaoming.notebook.basic.io.char_stream;

import pers.xiaoming.notebook.basic.io.Utils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

// File Reader's code looks almost the same as FileInputStream
// except the fact that input type change from byte[] to char[]

// FileReader doesn't provide read a String option
// in case of the input is so large that exceed the memory limit
public class FileReaderTest {
    private static File file;
    private static Reader reader;

    @BeforeClass
    public static void init() {
        File fileInit = new File(Utils.FILE_PATH + Utils.INPUT_FILE_NAME);

        if (fileInit.exists()) {
            file = fileInit;
        }
    }

    @Before
    public void setUp() throws FileNotFoundException {
        reader = new FileReader(file);
    }

    @After
    public void tearDown() throws IOException {
        reader.close();
    }

    @Test
    public void testReadByByteArray() throws IOException {
        char[] data = new char[256];
        int numOfBytes = reader.read(data);

        assertAndOutput(numOfBytes, data);
    }


    // Recommended
    @Test
    public void testOutputPartialData() throws IOException {
        char[] data = new char[256];
        int temp = 0;
        int index = 0;

        while( (temp = reader.read()) != -1) {
            data[index++] = (char) temp;
        }

        assertAndOutput(index, data);
    }

    // Rarely used in practice
    @Test
    public void testReadByByteDoWhile() throws IOException {
        char[] data = new char[256];
        int temp = 0;
        int index = 0;

        do {
            temp = reader.read();
            if (temp != -1) {
                data[index++] = (char) temp;
            }
        } while (temp != -1);

        assertAndOutput(index, data);
    }

    private void assertAndOutput(int length, char[] data) {
        Assert.assertEquals(236, length);
        System.out.println(length);

        System.out.println("{\n" + new String(data, 0 , length) + "\n}");
    }
}
