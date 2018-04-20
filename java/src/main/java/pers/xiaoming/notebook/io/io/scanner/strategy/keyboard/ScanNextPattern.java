package pers.xiaoming.notebook.io.io.scanner.strategy.keyboard;

import pers.xiaoming.notebook.io.io.scanner.ScannerImpl;
import pers.xiaoming.notebook.io.io.scanner.strategy.ScannerStrategy;

import java.util.Objects;
import java.util.Scanner;

class ScanNextPattern implements ScannerStrategy {
    // Not a strong pattern,
    // For example, 9805-96-88 still valids this pattern
    private static final String BIRTHDATE_PATTERN = "^\\d{4}-\\d{2}-\\d{2}$";

    @Override
    public void scan(Scanner scanner) {
        String birthdate = null;
        if(scanner.hasNext(BIRTHDATE_PATTERN)) {
            birthdate = scanner.next(BIRTHDATE_PATTERN);
        }

        System.out.print(Objects.requireNonNull(birthdate));
    }

    public static void main(String[] args) {
        ScannerImpl scanner = new ScannerImpl(new ScanNextPattern());
        scanner.scanKeyBoardPrintToConsole();
    }
}
