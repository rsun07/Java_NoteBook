package pers.xiaoming.notebook.basic.io.scanner.strategy.keyboard;

import pers.xiaoming.notebook.basic.io.scanner.ScannerImpl;
import pers.xiaoming.notebook.basic.io.scanner.strategy.ScannerStratety;

import java.util.InputMismatchException;
import java.util.Scanner;

class ScanNextDouble implements ScannerStratety {
    @Override
    public void scan(Scanner scanner) {
        Double num = null;
        System.out.println("Please enter a double: ");
        do {
            try {
                num = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("\nWrong input! Please enter a valid double: ");
                // ************
                // Tricky here,
                // if remove the new initialize of scanner,
                // Will stuck in old input stream
                // ************
                scanner.close();
                scanner = new Scanner(System.in);
            }
        } while (num == null);

        System.out.print(num);
    }

    public static void main(String[] args) {
        ScannerImpl scanner = new ScannerImpl(new ScanNextDouble());
        scanner.scanKeyBoardPrintToConsole();
    }
}
