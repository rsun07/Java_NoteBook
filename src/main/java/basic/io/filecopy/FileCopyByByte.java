package basic.io.filecopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopyByByte implements FileCopy {

    @Override
    public void copy(String sourcePath, String sourceFileName, String destPath,
                     String destFileName) throws IOException {

        File sourceFile = new File(sourcePath + File.separator + sourceFileName);

        File parentSourceFile = sourceFile.getParentFile();
        if (!parentSourceFile.exists() || !sourceFile.exists()) {
            throw new FileNotFoundException("Source file not exist!");
        }

        File destFile = new File(destPath  + File.separator + destFileName);
        if (!destFile.getParentFile().exists()) {
            throw new FileNotFoundException("Destination Dir not exist!");
        }

        System.out.printf("Start file copy from %s to %s\n",
                sourcePath + File.separator + sourceFileName,
                destPath + File.separator + destFileName);

        InputStream inputStream = new FileInputStream(sourceFile);
        OutputStream outputStream = new FileOutputStream(destFile);

        int temp = 0;
        while ((temp = inputStream.read()) != -1) {
            outputStream.write(temp);
        }
        inputStream.close();
        outputStream.close();

        System.out.printf("Successfully copy file from %s to %s\n",
                sourcePath + File.separator + sourceFileName,
                destPath + File.separator + destFileName);
    }
}
