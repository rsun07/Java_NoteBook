package pers.xiaoming.notebook.io.filecopy;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopyByByteArray implements FileCopyStrategy {

    @Override
    public void copy(InputStream inputStream, OutputStream outputStream) throws IOException {

        int temp = 0;
        byte[] data = new byte[1024];
        while ((temp = inputStream.read(data)) != -1) {
            outputStream.write(data, 0, temp);
        }
    }
}
