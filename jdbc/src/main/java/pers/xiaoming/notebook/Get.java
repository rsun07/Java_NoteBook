package pers.xiaoming.notebook;

import pers.xiaoming.notebook.entity.Student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Get {
    private static final String QUERY = "SELECT name, score FROM student";

    public List<Student> getAll() throws IOException, SQLException {
        return rsToStudents(getRs());
    }

    public ResultSet getRs() throws IOException, SQLException {
        try (Connection conn = ConnManager.getConn();
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery(QUERY);
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
