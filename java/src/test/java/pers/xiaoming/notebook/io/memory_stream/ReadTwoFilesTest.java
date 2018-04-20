package pers.xiaoming.notebook.io.memory_stream;

import pers.xiaoming.notebook.io.Utils;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ReadTwoFilesTest {
    @Test
    public void test() throws IOException {
        InputStream inputStreamA = new FileInputStream(
                new File(Utils.TWO_FILE_READ_PATH + "file_a"));
        InputStream inputStreamB = new FileInputStream(
                new File(Utils.TWO_FILE_READ_PATH + "file_b"));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        write(inputStreamA, outputStream);
        write(inputStreamB, outputStream);

        String output = new String(outputStream.toByteArray());
        inputStreamA.close();
        inputStreamB.close();
        outputStream.close();

        String expect = "file_a\nfile_a demo\nfile_b\nfile_b demo\n";

        Assert.assertEquals(expect, output);

        System.out.println(output);
    }

    private void write(InputStream inputStream, OutputStream outputStream) throws IOException {
        int temp = 0;
        while((temp= inputStream.read()) != -1) {
            outputStream.write(temp);
        }
    }
}
