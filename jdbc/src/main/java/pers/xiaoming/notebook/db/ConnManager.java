package pers.xiaoming.notebook.db;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnManager {
    private static final String CONFIG_PATH = "." + File.separator + "src" + File.separator + "main"
            + File.separator + "resources" + File.separator;

    private static String url;
    private static Properties props;

    private ConnManager() throws IOException {
        FileReader reader = new FileReader(CONFIG_PATH + "/mysql.properties");
        Properties properties = new Properties();
        properties.load(reader);

        url = properties.getProperty("url");

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);

        reader.close();
    }

    public static Connection getConn() throws SQLException, IOException {
        try {
            if (url == null || props == null) {
                synchronized (ConnManager.class) {
                    new ConnManager();
                }
            }
            // return DriverManager.getConnection(url, user, password);
            return DriverManager.getConnection(url, props);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
