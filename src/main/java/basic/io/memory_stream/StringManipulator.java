package basic.io.memory_stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StringManipulator {
    static String toUpperCase(String string) throws IOException {
        InputStream inputStream = new ByteArrayInputStream(string.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();

        int temp = 0;
        while ((temp = inputStream.read()) != -1) {
            outputStream.write(Character.toUpperCase(temp));
        }

        String result = outputStream.toString();
        inputStream.close();
        outputStream.close();
        return result;
    }
}
