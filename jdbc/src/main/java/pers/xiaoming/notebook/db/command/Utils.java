package pers.xiaoming.notebook.db.command;

import pers.xiaoming.notebook.entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Utils {
    public static Student rsToStudents(ResultSet rs) throws SQLException {
        Student student = null;

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double score = rs.getDouble("score");
            student = new Student(id, name, score);
        }
        return student;
    }
}
