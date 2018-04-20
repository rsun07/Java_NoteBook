package pers.xiaoming.notebook.io.nio.filecopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileCopierNIOImpl {
    public static void copy(String src, String dest) throws IOException {
        try(FileInputStream fi = new FileInputStream(new File(src));
            FileOutputStream fo = new FileOutputStream(new File(dest));
            FileChannel inChannel = fi.getChannel();
            FileChannel outChannel = fo.getChannel()
        ) {

            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (true) {
                int eof = inChannel.read(buffer);
                if (eof == -1) {
                    break;
                }

                // set limit to current position
                // and set position to 0
                // see source code for detail
                buffer.flip();

                outChannel.write(buffer);

                // after write, set position to 0
                // limit to capacity
                buffer.clear();
            }
        }
    }
}
