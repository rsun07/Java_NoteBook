package pers.xiaoming.notebook.io.nio.filecopy;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import static pers.xiaoming.notebook.io.Utils.FILE_COPY_DEST_NAME;
import static pers.xiaoming.notebook.io.Utils.FILE_COPY_DEST_PATH;
import static pers.xiaoming.notebook.io.Utils.FILE_COPY_SOURCE_NAME;
import static pers.xiaoming.notebook.io.Utils.FILE_COPY_SOURCE_PATH;

@Ignore("don't run, demo test")
public class ByteBufferTesting {
    private FileInputStream fi;
    private FileOutputStream fo;
    private FileChannel inChannel;
    private FileChannel outChannel;
    private ByteBuffer buffer;

    @Before
    public void setUp() throws FileNotFoundException {
        fi = new FileInputStream(new File(FILE_COPY_SOURCE_PATH + File.separator + FILE_COPY_SOURCE_NAME));
        File outfile = new File(FILE_COPY_DEST_PATH + File.separator + FILE_COPY_DEST_NAME);
        // outfile.deleteOnExit();
        // manually delete out file before test
        fo = new FileOutputStream(outfile);

        inChannel = fi.getChannel();
        outChannel = fo.getChannel();
        buffer = ByteBuffer.allocate(128);
    }

    @After
    public void tearDown() throws IOException {
        inChannel.close();
        outChannel.close();
        fi.close();
        fo.close();

    }


    @Test
    public void correctFileCopy() throws IOException {
        while (true) {
            // Because ByteBuffer is allocate to 128, so the ByteBuffer will read 128 byte each time.
            // That means the attribute inside ByteBuffer, capacity = 128.
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

    // use debug mode to see what happens
    @Test
    public void testWithoutFlip() throws IOException {
        while (true) {
            int eof = inChannel.read(buffer);

            if (eof == -1) {
                break;
            }

            // buffer.flip();

            // without flip, position won't back to 0
            // out channel write from the position
            outChannel.write(buffer);

            buffer.clear();
        }
    }
}
