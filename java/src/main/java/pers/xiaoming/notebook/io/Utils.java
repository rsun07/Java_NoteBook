package pers.xiaoming.notebook.io;

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

    public static final String IMAGE_COPY_SOURCE_NAME = "source_img.jpg";

    public static final String IMAGE_COPY_DEST_NAME = "copy_dest_img.jpg";

    public static final String FILE_COPY_SOURCE_NAME = "source_file.txt";

    public static final String FILE_COPY_DEST_NAME = "copy_dest_file.txt";

    // For two File read test in memory stream
    public static final String TWO_FILE_READ_PATH =  "." + File.separator + "src" + File.separator + "main" + File.separator +
            "resources" + File.separator + "io" + File.separator + "memory_stream" + File.separator;

    // For Scanner test
    public static final String SCANNER_FILE_PATH =  "." + File.separator + "src" + File.separator + "main" + File.separator +
            "resources" + File.separator + "io" + File.separator + "scanner" + File.separator;

    public static final String SCANNER_FILE_NAME = "file";



    // for Serialization test
    public static final String SERIALIZATION_FILE_PATH =  "." + File.separator + "src" + File.separator + "main" + File.separator +
            "resources" + File.separator + "io" + File.separator + "serialization" + File.separator;

    public static final String SERIALIZATION_FILE_NAME = "file";

    public static final String XML_SERIALIZATION_FILE_NAME = "xml_file.xml";
}
