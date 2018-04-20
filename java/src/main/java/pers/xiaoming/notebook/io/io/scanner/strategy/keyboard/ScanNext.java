package pers.xiaoming.notebook.io.io.scanner.strategy.keyboard;

import pers.xiaoming.notebook.io.io.scanner.ScannerImpl;
import pers.xiaoming.notebook.io.io.scanner.strategy.ScannerStrategy;

import java.util.Scanner;

class ScanNext implements ScannerStrategy {
    @Override
    public void scan(Scanner scanner) {
        StringBuilder sb = new StringBuilder();
        while(scanner.hasNext()) {

            // by default, delimiter by space (" ") and return ("\n")
            String nextString = scanner.next();
            if (nextString.equals("stop")) {
                break;
            }
            sb.append(nextString);
            sb.append("\t<{dilimiter>}\t");
        }

        System.out.print(sb.toString());
    }

    public static void main(String[] args) {
        ScannerImpl scanner = new ScannerImpl(new ScanNext());
        scanner.scanKeyBoardPrintToConsole();
    }
}
