package pers.xiaoming.notebook.db.command;

import pers.xiaoming.notebook.db.ConnManager;
import pers.xiaoming.notebook.entity.Student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Get {
    private static final String QUERY = "SELECT name, score FROM student WHERE id = ?";

    public Student run(int id) throws IOException, SQLException {
        try (Connection conn = ConnManager.getConn();
             PreparedStatement ps = conn.prepareStatement(QUERY)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            return rsToStudents(rs).get(0);
        }
    }

    private List<Student> rsToStudents(ResultSet rs) throws SQLException {
        List<Student> students = new ArrayList<>();

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double score = rs.getDouble("score");
            students.add(new Student(id, name, score));
        }
        return students;
    }
}
