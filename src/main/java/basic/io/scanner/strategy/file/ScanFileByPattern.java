package basic.io.scanner.strategy.file;

import basic.io.Utils;
import basic.io.scanner.ScannerImpl;
import basic.io.scanner.strategy.ScannerStratety;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

class ScanFileByPattern implements ScannerStratety {
    private Pattern pattern;

    ScanFileByPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    @Override
    public void scan(Scanner scanner) {
        while(scanner.hasNext()) {
            if (scanner.hasNext(pattern)) {
                System.out.println(scanner.next(pattern));
            } else {
                scanner.next();
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Pattern pattern = Pattern.compile("\\d+");
        ScannerImpl scanner = new ScannerImpl(new ScanFileByPattern(pattern));
        scanner.scanFilePrintToConsole(Utils.SCANNER_FILE_PATH, Utils.SCANNER_FILE_NAME);
    }
}
