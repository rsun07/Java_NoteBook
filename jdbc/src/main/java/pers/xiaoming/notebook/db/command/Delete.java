package pers.xiaoming.notebook.db.command;

import pers.xiaoming.notebook.db.ConnManager;
import pers.xiaoming.notebook.entity.Student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
    private static final String QUERY = "DELETE student WHERE id = ?";

    public void run(int id) throws IOException, SQLException {
        try (Connection conn = ConnManager.getConn();
             PreparedStatement ps = conn.prepareStatement(QUERY)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
