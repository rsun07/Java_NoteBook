package pers.xiaoming.notebook.db.command;

import pers.xiaoming.notebook.db.ConnManager;
import pers.xiaoming.notebook.entity.Student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Get {
    private static final String QUERY = "SELECT id, name, score FROM student WHERE id = ?";

    public Student run(int id) throws IOException, SQLException {
        try (Connection conn = ConnManager.getConn();
             PreparedStatement ps = conn.prepareStatement(QUERY)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            return Utils.rsToStudents(rs);
        }
    }
}
