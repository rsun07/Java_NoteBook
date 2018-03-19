package basic.io.scanner;

import java.util.Scanner;

class ScannerImpl {
    private ScannerStratety stratety;

    ScannerImpl(ScannerStratety stratety) {
        this.stratety = stratety;
    }

    void scanKeyBoardPrintToConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input from keyboard:\n");
        stratety.scan(scanner);
        System.out.println("\n\nScanner completed!");
    }
}
