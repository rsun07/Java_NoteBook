package pers.xiaoming.notebook;

import pers.xiaoming.notebook.entity.Student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Get {
    private static final String SELECT_ALL_QUERY = "SELECT name, score FROM student";

    private static final String SELECT_BY_ID_QUERY = "SELECT name, score FROM student WHERE id = ?";

    public List<Student> getAll() throws IOException, SQLException {
        return rsToStudents(getRs());
    }

    public ResultSet getRs() throws IOException, SQLException {
        try (Connection conn = ConnManager.getConn();
             PreparedStatement ps = conn.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet rs = ps.executeQuery(SELECT_ALL_QUERY);
            return rs;
        }
    }

    public Student get(int id) throws IOException, SQLException {
        return rsToStudents(getRs()).get(0);
    }

    public ResultSet getRs(int id) throws IOException, SQLException {
        try (Connection conn = ConnManager.getConn();
             PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_QUERY)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery(SELECT_ALL_QUERY);
            return rs;
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
