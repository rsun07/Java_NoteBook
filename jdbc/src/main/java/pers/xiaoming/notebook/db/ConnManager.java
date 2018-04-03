package pers.xiaoming.notebook.db;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnManager {
    private static final String CONFIG_PATH = "."+ File.separator + "jdbc" + File.separator + "src" + File.separator + "main"
            + File.separator + "resources" + File.separator;

    public static Connection getConn() throws IOException, SQLException {
        try {
            FileReader reader = new FileReader(CONFIG_PATH + "/mysql.properties");
            Properties properties = new Properties();
            properties.load(reader);

            reader.close();

            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");

            return DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
