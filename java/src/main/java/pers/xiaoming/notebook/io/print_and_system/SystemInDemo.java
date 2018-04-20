package pers.xiaoming.notebook.io.print_and_system;

import java.io.IOException;
import java.io.InputStream;

public class SystemInDemo {
    public static void main(String[] args) throws IOException {
        SystemInDemo systemInDemo = new SystemInDemo();
        // systemInDemo.readByByteArray();
        systemInDemo.readByByte();
    }

    private void readByByteArray() throws IOException {
        InputStream inputStream = System.in;

        // Try a small byte size, then info will be missing
        // byte[] data = new byte[6];
        byte[] data = new byte[1024];
        System.out.println("Please input: ");
        int len = inputStream.read(data);

        System.out.println("Output is: " + new String(data, 0, len));
    }

    private void readByByte() throws IOException {
        InputStream inputStream = System.in;

        StringBuffer sb = new StringBuffer();
        int temp = 0;

        System.out.println("Please input: ");
        while ((temp = inputStream.read()) != '\n') {
            sb.append((char) temp);
        }

        System.out.println("Output is: " + sb.toString());
    }
}
