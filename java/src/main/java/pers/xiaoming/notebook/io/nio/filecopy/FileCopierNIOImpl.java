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

            // Because ByteBuffer is allocate to 1024, so the ByteBuffer will read 1024 byte each time.
            // That means the attribute inside ByteBuffer, capacity = 1024.
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (true) {
                int eof = inChannel.read(buffer);

                // the stop sign is -1,
                // or could be change by changing the mark attribute in buffer
                if (eof == -1) {
                    break;
                }

                // 128 or less byte is already loaded into buffer
                // position is equals to the int eof
                // flip will set limit to current position
                // and then set position to 0

                // position is like the start index
                // limit is like the end index
                buffer.flip();

                // write from position to limit
                outChannel.write(buffer);

                // after write, set position to 0
                // limit to capacity
                // free the buffer to receive more message
                buffer.clear();
            }
        }
    }
}
