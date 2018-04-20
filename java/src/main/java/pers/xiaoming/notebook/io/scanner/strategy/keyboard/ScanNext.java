package pers.xiaoming.notebook.io.scanner.strategy.keyboard;

import pers.xiaoming.notebook.io.scanner.ScannerImpl;
import pers.xiaoming.notebook.io.scanner.strategy.ScannerStratety;

import java.util.Scanner;

class ScanNext implements ScannerStratety {
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
