package pers.xiaoming.notebook.db.transaction;

import pers.xiaoming.notebook.db.ConnManager;
import pers.xiaoming.notebook.db.command.Utils;
import pers.xiaoming.notebook.entity.Student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetAndDelete {
    private static final String SELECT_QUERY = "SELECT id, name, score FROM student WHERE id = ?;";
    private static final String DELETE_QUERY = "DELETE FROM student WHERE id = ?;";


    public Student run(int id) throws SQLException, IOException {
        try (Connection conn = ConnManager.getConn()) {
            try {
                conn.setAutoCommit(false);

                PreparedStatement selectPs = conn.prepareStatement(SELECT_QUERY);
                selectPs.setInt(1, id);

                PreparedStatement deletePs = conn.prepareStatement(DELETE_QUERY);
                deletePs.setInt(1, id);

                ResultSet rs = selectPs.executeQuery();

                deletePs.executeUpdate();

                conn.commit();

                return Utils.rsToStudents(rs);
            } catch (Exception e) {
                conn.rollback();
                throw e;
            }
        }
    }
}
