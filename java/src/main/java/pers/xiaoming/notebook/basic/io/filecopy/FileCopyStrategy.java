package basic.io.filecopy;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface FileCopyStrategy {
    void copy(InputStream inputStream, OutputStream outputStream) throws IOException;
}
