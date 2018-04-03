package pers.xiaoming.notebook.db.command;

import pers.xiaoming.notebook.db.ConnManager;
import pers.xiaoming.notebook.entity.Student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    private static final String QUERY = "UPDATE student SET name = ?, score = ? WHERE id = ?";


    public void run(Student student) throws IOException, SQLException {
        try (Connection conn = ConnManager.getConn();
             PreparedStatement ps = conn.prepareStatement(QUERY)) {

            ps.setString(1, student.getName());
            ps.setDouble(2, student.getScore());
            ps.setInt(3, student.getId());
            ps.executeUpdate();
        }
    }
}
