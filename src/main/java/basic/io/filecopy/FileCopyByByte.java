package basic.io.filecopy;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopyByByte implements FileCopyStrategy {

    @Override
    public void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        int temp = 0;
        while ((temp = inputStream.read()) != -1) {
            outputStream.write(temp);
        }
    }
}
