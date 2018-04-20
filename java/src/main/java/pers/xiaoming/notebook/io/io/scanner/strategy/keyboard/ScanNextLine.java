package pers.xiaoming.notebook.io.io.scanner.strategy.keyboard;

import pers.xiaoming.notebook.io.io.scanner.ScannerImpl;
import pers.xiaoming.notebook.io.io.scanner.strategy.ScannerStrategy;

import java.util.Scanner;

class ScanNextLine implements ScannerStrategy {
    @Override
    public void scan(Scanner scanner) {
        StringBuilder sb = new StringBuilder();
        while(scanner.hasNextLine()) {

            // the return "\n" will be removed from nextLine
            String nextLine = scanner.nextLine();
            if (nextLine.equals("stop")) {
                break;
            }
            sb.append(nextLine);
            sb.append("\t<{dilimiter>}\t");
        }

        System.out.print(sb.toString());
    }

    public static void main(String[] args) {
        ScannerImpl scanner = new ScannerImpl(new ScanNextLine());
        scanner.scanKeyBoardPrintToConsole();
    }
}
