package pers.xiaoming.notebook.io.bufferedreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyBoardReader {
    public static void main(String[] args) throws IOException {
        // BufferedReader inherit from Reader,
        // System.in is an InputStream
        // Use InputStreamReader to convert 
        // from InputStream (byte stream) to Reader (char stream).
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        
        boolean isRightInput = false;
        
        String line = null;
        while(!isRightInput) {
            System.out.print("Please input age:");
            line = br.readLine();
            if (line.matches("\\d{1,3}")) {
                isRightInput = true;
            } else {
                System.err.println("Wrong input, please input a integer for age!");
            }
        }
        
        System.out.println("Input age is: " + Integer.valueOf(line));

        br.close();
    }
}
