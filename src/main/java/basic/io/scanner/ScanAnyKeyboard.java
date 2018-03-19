package basic.io.scanner;

import java.util.Scanner;

public class ScanAnyKeyboard implements ScannerStratety {
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
        ScannerImpl scanner = new ScannerImpl(new ScanAnyKeyboard());
        scanner.scanKeyBoardPrintToConsole();
    }
}
