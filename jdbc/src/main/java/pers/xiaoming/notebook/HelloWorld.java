package pers.xiaoming.notebook;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class HelloWorld {

    private static final String CONFIG_PATH = "."+ File.separator + "jdbc" + File.separator + "src" + File.separator + "main"
            + File.separator + "resources" + File.separator;

    public static void main(String args[]) {
        try {

            FileReader reader = new FileReader(CONFIG_PATH + "/mysql.properties");
            Properties properties = new Properties();
            properties.load(reader);

            reader.close();

            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");

            Connection conn = DriverManager.getConnection(url, user, password);

            System.out.println(conn);

            Statement stmt1 = conn.createStatement();

            System.out.println(stmt1);

            Statement stmt2 = conn.createStatement();

            System.out.println(stmt2);

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
