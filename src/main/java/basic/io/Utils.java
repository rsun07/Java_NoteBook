package basic.io;

import java.io.File;

public class Utils {

    // For File input and output tests
    public static final String FILE_PATH = "." + File.separator + "src" + File.separator + "main" + File.separator +
            "resources" + File.separator + "io" + File.separator + "byte_stream" + File.separator;

    public static final String OUTPUT_FILE_NAME = "file_output";

    public static final String INPUT_FILE_NAME = "file_input";

    // For File copy tests
    public static final String FILE_COPY_SOURCE_PATH =  "." + File.separator + "src" + File.separator + "main" + File.separator +
            "resources" + File.separator + "io" + File.separator + "filecopy" + File.separator + "copyinput" + File.separator;

    public static final String FILE_COPY_DEST_PATH = "." + File.separator + "src" + File.separator + "main" + File.separator +
            "resources" + File.separator + "io" + File.separator + "filecopy" + File.separator+ "copyoutput" + File.separator;

    public static final String FILE_COPY_SOURCE_NAME = "source_file.jpg";

    public static final String FILE_COPY_DEST_NAME = "copy_dest_file";
}
