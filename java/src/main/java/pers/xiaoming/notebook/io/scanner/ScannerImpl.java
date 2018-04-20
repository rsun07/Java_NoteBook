package pers.xiaoming.notebook.io.scanner;

import pers.xiaoming.notebook.io.scanner.strategy.ScannerStrategy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerImpl {
    private ScannerStrategy strategy;

    public ScannerImpl(ScannerStrategy strategy) {
        this.strategy = strategy;
    }

    public void scanKeyBoardPrintToConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input from keyboard:\n");
        strategy.scan(scanner);
        scanner.close();
        System.out.println("\n\nScanner completed!");
    }

    public void scanFilePrintToConsole(String filePath, String fileName) throws FileNotFoundException {
        String path = filePath + File.separator + fileName;
        File file = new File(path);
        if (!file.exists()) {
            System.exit(1);
        }
        Scanner scanner = new Scanner(new FileInputStream(file));

        System.out.println("Start to scan file: " + path);
        strategy.scan(scanner);
        System.out.println("\nScan completed: ");

    }
}
