package pers.xiaoming.notebook.io.byte_stream;

import org.junit.Ignore;
import pers.xiaoming.notebook.io.Utils;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStreamTest {
    private static File file;
    private static OutputStream outputStream;

    @BeforeClass
    public static void init() {
        File fileInit = new File(Utils.FILE_PATH + Utils.OUTPUT_FILE_NAME);

        if (! fileInit.getParentFile().exists()) {
            fileInit.mkdirs();
        }

        file = fileInit;
    }

    @After
    public void tearDown() throws IOException {
        outputStream.flush();
        outputStream.close();
    }

    // Need to comment the clean method
    // if you want to check the output file
    // @AfterClass
    // public static void clean() {
    //     file.deleteOnExit();
    // }

    @Test
    public void testOutputByByteArray() throws IOException {
        outputStream = new FileOutputStream(file);

        String output = "output by byte array";
        byte[] data = output.getBytes();
        outputStream.write(data);
    }

    @Test
    public void testOutputByByte() throws IOException {
        outputStream = new FileOutputStream(file);

        String output = "output by byte";
        byte[] data = output.getBytes();
        for (byte b : data) {
            outputStream.write(b);
        }
    }

    @Test
    public void testOutputPartialData() throws IOException {
        outputStream = new FileOutputStream(file);

        String output = "--- output partial ";
        byte[] data = output.getBytes();
        outputStream.write(data, 3, 16);
    }

    @Test
    public void testOutputAppend() throws IOException {
        outputStream = new FileOutputStream(file, true);

        String output = "append this \n\r";
        byte[] data = output.getBytes();
        outputStream.write(data);
    }
}
