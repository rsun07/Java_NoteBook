package basic.io.scanner.strategy.file;

import basic.io.Utils;
import basic.io.scanner.ScannerImpl;
import basic.io.scanner.strategy.ScannerStratety;

import java.io.FileNotFoundException;
import java.util.Scanner;

class ScanFileByLine implements ScannerStratety {
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
