package pers.xiaoming.notebook.io.io.file_operation;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileCreationDeletionTest {
    // Use File.separator here instead of File.pathSeparator
    private static final String FILE_DIR = "." + File.separator + "src" + File.separator + "main" + File.separator +
            "resources" + File.separator + "io" + File.separator + "file_creation_demo" + File.separator;

    private static final String FILE_NAME = "file_creation_test.txt";

    @Test
    public void test() throws IOException {
        File file = new File(FILE_DIR + FILE_NAME);

        System.out.println(file.getParentFile());

        if (!file.getParentFile().exists()) {
            boolean mkdir = file.getParentFile().mkdir();
            System.out.println(mkdir);
        }

        if (! file.exists()) {
            file.createNewFile();
        }

        if (file.exists()) {
            file.deleteOnExit();
        }

        if (file.getParentFile().exists()) {
            file.getParentFile().deleteOnExit();
        }
    }
}
