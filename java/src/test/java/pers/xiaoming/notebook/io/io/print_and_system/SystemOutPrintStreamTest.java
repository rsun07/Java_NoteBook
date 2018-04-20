package pers.xiaoming.notebook.io.io.print_and_system;

import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

public class SystemOutPrintStreamTest {

    @Test
    public void testSystemOut() throws IOException {
        OutputStream outputStream = System.out;
        outputStream.write("Hello World!".getBytes());

        // Don't close it, because the System.out is managed by System
        // outputStream.close();

        // System.out is a PrintStream initialized, managed and closed by System
        PrintStream printStream = System.out;
        printStream.println();
        printStream.println(8.8);
        printStream.println(6);
        printStream.println('A');

        // Same reason as above
        // printStream.close();
    }

    @Test
    public void testFunctionalInterface() {
        Consumer<String> output = System.out::println;
        output.accept("Hello World!");
    }
}
