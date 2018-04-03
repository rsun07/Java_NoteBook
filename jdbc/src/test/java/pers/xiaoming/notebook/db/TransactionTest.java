package pers.xiaoming.notebook.db;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pers.xiaoming.notebook.db.command.Create;
import pers.xiaoming.notebook.db.command.Get;
import pers.xiaoming.notebook.db.transaction.GetAndDelete;
import pers.xiaoming.notebook.entity.Student;

import java.io.IOException;
import java.sql.SQLException;

public class TransactionTest {
    private static int id;
    private static Student student;

    @BeforeClass
    public static void setUp() throws IOException, SQLException {
        student = new Student("John", 88.5);
        id = new Create().run(student);
        student.setId(id);
    }

    @Test
    public void getTest() throws IOException, SQLException {
        Student studentReturn = new GetAndDelete().run(id);
        Assert.assertEquals(studentReturn, student);

        Assert.assertNull(new Get().run(id));
    }


}
