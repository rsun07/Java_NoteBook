package pers.xiaoming.notebook.io.io.char_stream;

import pers.xiaoming.notebook.io.Utils;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWriterTest {

    private static File file;
    private static Writer writer;

    @BeforeClass
    public static void init() {
        File fileInit = new File(Utils.FILE_PATH + Utils.OUTPUT_FILE_NAME);
        if (fileInit.exists()) {
            file = fileInit;
        }
    }

    @Before
    public void setUp() throws IOException {
        writer = new FileWriter(file);
    }

    @After
    public void tearDown() throws IOException {
        writer.close();
    }

    @Test
    public void testWriteCharArray() throws IOException {
        String output = "write by Byte Array";
        char[] data = output.toCharArray();
        writer.write(data);
    }

    @Test
    public void testWriteString() throws IOException {
        String output = "write by String";
        writer.write(output);
    }

    @Test
    public void testWritePartialStr() throws IOException {
        String output = "----- write by Byte Array";
        writer.write(output, 3, 12);
    }

    @Test
    public void testAppend() throws IOException {
        String output = "\n\rappend this";
        // need a input type CharSequence
        // String implements CharSequence Interface
        writer.append(output);
    }
}
