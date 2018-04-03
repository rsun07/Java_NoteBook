package pers.xiaoming.notebook.db.command;

import org.junit.Assert;
import org.testng.annotations.Test;
import pers.xiaoming.notebook.entity.Student;

import java.io.IOException;
import java.sql.SQLException;

public class CURDTest {
    private Student student;
    private int id;

    @Test
    public void testCreate() throws IOException, SQLException {
        student = new Student("John", 88.5);

        int id = new Create().run(student);

        this.id = id;
        student.setId(id);

        validate(this.student);
    }

    @Test(dependsOnMethods = "testCreate")
    public void testUpdate() throws IOException, SQLException {
        student.setScore(98.5);
        new Update().run(student);

        validate(this.student);
    }


    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws IOException, SQLException {
        new Delete().run(this.id);
        validate(null);
    }

        private void validate(Student expectStudent) throws IOException, SQLException {
        Student studentReturn = new Get().run(this.id);
        Assert.assertEquals(studentReturn, expectStudent);
    }
}
