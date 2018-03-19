package basic.io.scanner;

import basic.io.scanner.strategy.ScannerStratety;

import java.util.Scanner;

public class ScannerImpl {
    private ScannerStratety stratety;

    public ScannerImpl(ScannerStratety stratety) {
        this.stratety = stratety;
    }

    public void scanKeyBoardPrintToConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input from keyboard:\n");
        stratety.scan(scanner);
        System.out.println("\n\nScanner completed!");
    }
}
