package basic.io.bufferedreader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static basic.io.Utils.FILE_PATH;
import static basic.io.Utils.INPUT_FILE_NAME;

public class BufferedFileReader {
    public static void main(String[] args) throws IOException {
        File file = new File(FILE_PATH + INPUT_FILE_NAME);

        if (!file.exists()) {
            System.exit(1);
        }

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        StringBuilder sb = new StringBuilder();
        while ( (line = br.readLine()) != null) {
            sb.append(line);
            sb.append('\n');
        }


        System.out.println(sb.toString());

        br.close();
    }
}
