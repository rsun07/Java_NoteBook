package basic.io.filecopy;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileCopy {
    void copy(String sourcePath, String sourceFileName,
              String destPath, String destFileName) throws IOException;
}
