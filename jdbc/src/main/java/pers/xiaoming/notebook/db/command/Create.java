package pers.xiaoming.notebook.db.command;

import pers.xiaoming.notebook.db.ConnManager;
import pers.xiaoming.notebook.entity.Student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Create {
    private static final String QUERY = "INSERT INTO student (name, score) values (?, ?)";


    public int insert(Student student) throws IOException, SQLException {
        try (Connection conn = ConnManager.getConn();
             PreparedStatement ps = conn.prepareStatement(QUERY)) {

            ps.setString(1, student.getName());
            ps.setDouble(2, student.getScore());
            int count = ps.executeUpdate();
            return count;
        }
    }
}
