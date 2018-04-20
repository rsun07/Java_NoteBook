package pers.xiaoming.notebook.io.scanner.strategy.file;

import pers.xiaoming.notebook.io.Utils;
import pers.xiaoming.notebook.io.scanner.ScannerImpl;
import pers.xiaoming.notebook.io.scanner.strategy.ScannerStrategy;

import java.io.FileNotFoundException;
import java.util.Scanner;

class ScanFileByAnyDelimiter implements ScannerStrategy {
    private String delimiter;

    ScanFileByAnyDelimiter(String[] delimiters) {
        initDelimiter(delimiters);
    }

    private void initDelimiter(String[] delimiters) {
        StringBuilder sb = new StringBuilder();
        for (String delimiter: delimiters) {
            sb.append(delimiter);
            sb.append('|');
        }
        sb.delete(sb.length() - 1, sb.length());
        this.delimiter =  sb.toString();
    }

    @Override
    public void scan(Scanner scanner) {
        scanner.useDelimiter(this.delimiter);
        while(scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        String[] delimiters = {"\n", " ", "\t"};
        ScannerImpl scanner = new ScannerImpl(new ScanFileByAnyDelimiter(delimiters));
        scanner.scanFilePrintToConsole(Utils.SCANNER_FILE_PATH, Utils.SCANNER_FILE_NAME);
    }
}
