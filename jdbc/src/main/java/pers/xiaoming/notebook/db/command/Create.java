package pers.xiaoming.notebook.db.command;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import lombok.extern.slf4j.Slf4j;
import pers.xiaoming.notebook.db.ConnManager;
import pers.xiaoming.notebook.entity.Student;

import java.io.IOException;
import java.rmi.server.ExportException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
public class Create {
    private static final String QUERY = "INSERT INTO student (name, score) values (?, ?)";

    public int run(Student student) throws IOException, SQLException {
        try (Connection conn = ConnManager.getConn();
             PreparedStatement ps = conn.prepareStatement(QUERY, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, student.getName());
            ps.setDouble(2, student.getScore());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                } else {
                    log.error("no key return from db student = {}", student);
                    throw new SQLException("insert fail!");
                }
            }
        }
    }
}
