package pers.xiaoming.notebook.io.filecopy;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

import static pers.xiaoming.notebook.io.Utils.IMAGE_COPY_DEST_NAME;
import static pers.xiaoming.notebook.io.Utils.FILE_COPY_DEST_PATH;
import static pers.xiaoming.notebook.io.Utils.IMAGE_COPY_SOURCE_NAME;
import static pers.xiaoming.notebook.io.Utils.FILE_COPY_SOURCE_PATH;

public class FileCopyByByteArrayTest {
    @BeforeClass
    public static void setUp() {
        File destFile = new File(FILE_COPY_DEST_PATH + File.separator + IMAGE_COPY_DEST_NAME);
        destFile.deleteOnExit();
    }

    @Test
    public void test() throws IOException {
        Instant start = Instant.now();

        FileCopier fileCopier = new FileCopierImpl(
                FILE_COPY_SOURCE_PATH + File.separator + IMAGE_COPY_SOURCE_NAME,
                FILE_COPY_DEST_PATH + File.separator + IMAGE_COPY_DEST_NAME,
                new FileCopyByByte()
        );
        fileCopier.copy();

        Instant end = Instant.now();

        System.out.printf("\nThe copy cost %d ms\n", Duration.between(start, end).toMillis());
    }
}
