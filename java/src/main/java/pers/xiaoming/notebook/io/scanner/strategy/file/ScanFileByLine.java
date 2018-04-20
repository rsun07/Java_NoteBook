package pers.xiaoming.notebook.io.scanner.strategy.file;

import pers.xiaoming.notebook.io.Utils;
import pers.xiaoming.notebook.io.scanner.ScannerImpl;
import pers.xiaoming.notebook.io.scanner.strategy.ScannerStrategy;

import java.io.FileNotFoundException;
import java.util.Scanner;

class ScanFileByLine implements ScannerStrategy {
    @Override
    public void scan(Scanner scanner) {
        while(scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        ScannerImpl scanner = new ScannerImpl(new ScanFileByLine());
        scanner.scanFilePrintToConsole(Utils.SCANNER_FILE_PATH, Utils.SCANNER_FILE_NAME);
    }
}
