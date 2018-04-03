package pers.xiaoming.notebook.db.command;

import pers.xiaoming.notebook.db.ConnManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TruncateTable {
    private static final String QUERY = "TRUNCATE TABLE student";

    public void run() throws IOException, SQLException {
        try (Connection conn = ConnManager.getConn();
             PreparedStatement ps = conn.prepareStatement(QUERY)) {
            ps.executeUpdate();
        }
    }
}
