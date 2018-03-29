package pers.xiaoming.notebook.basic.io.file_operation;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class FileMethodsTest {

    private static final String FILE_DIR = "." + File.separator + "src" + File.separator + "main" + File.separator +
            "resources" + File.separator + "io" + File.separator + "directory" + File.separator;
    @Test
    public void test() {
        File directory = new File(FILE_DIR);

        Assert.assertTrue(directory.exists());

        Assert.assertTrue(directory.isDirectory());

        Assert.assertFalse(directory.isFile());

        String[] fileNames = directory.list();
        String[] expectedFileNames = {"demo.txt", "file.txt"};
        Assert.assertArrayEquals(expectedFileNames, fileNames);

        File[] files = directory.listFiles();
        for (File file : files) {
            Assert.assertTrue(file.isFile());
            Assert.assertFalse(file.isDirectory());
            Assert.assertFalse(file.isHidden());
            System.out.println("\nFile Name: " + file.getName());

            long lastModifiedAt = file.lastModified();
            LocalDateTime lastModifiedTime = LocalDateTime.ofInstant(
                                                Instant.ofEpochMilli(lastModifiedAt),
                                                ZoneId.systemDefault()
                                             );
            System.out.println("Last Modified At: " + lastModifiedTime);


            System.out.printf("File Size: %.2f K \n", ((double) file.length()) /  1024);
        }
    }
}
