package pers.xiaoming.notebook;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
    private static final String QUERY = "INSERT INTO student (name, score) values (50, 88)";


    public int insert() throws IOException, SQLException {
        Connection conn = ConnManager.getConn();
        Statement stmt = conn.createStatement();
        int count = stmt.executeUpdate(QUERY);
        return count;
    }
}
