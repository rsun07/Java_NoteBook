package pers.xiaoming.notebook.io.io.filecopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopierImpl implements FileCopier {

    private String sourceFilePath;
    private String destFilePath;
    private FileCopyStrategy strategy;

    FileCopierImpl(String sourceFilePath, String destFilePath, FileCopyStrategy strategy) {
        this.sourceFilePath = sourceFilePath;
        this.destFilePath = destFilePath;
        this.strategy = strategy;
    }

    @Override
    public void copy() throws IOException {
        File sourceFile = new File(sourceFilePath);

        File parentSourceFile = sourceFile.getParentFile();
        if (!parentSourceFile.exists() || !sourceFile.exists()) {
            throw new FileNotFoundException("Source file not exist!");
        }

        File destFile = new File(destFilePath);
        if (!destFile.getParentFile().exists()) {
            throw new FileNotFoundException("Destination Dir not exist!");
        }

        System.out.printf("Start file copy from %s to %s by %s\n",
                sourceFilePath,
                destFilePath,
                this.getClass().getName());

        InputStream inputStream = new FileInputStream(sourceFile);
        OutputStream outputStream = new FileOutputStream(destFile);

        strategy.copy(inputStream, outputStream);

        inputStream.close();
        outputStream.close();

        System.out.printf("Successfully copy file from %s to %s using %s\n",
                sourceFilePath,
                destFilePath,
                this.getClass().getName());
    }
}
