package basic.lang.property_read;

import org.junit.Assert;
import org.junit.Test;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class PropertyFileTest {
    @Test
    public void readPropertiesFile() {
        // Don't need the ".properties" suffix
        // Must add the property file into CLASSPATH
        ResourceBundle rb = ResourceBundle.getBundle("helloworld");
        System.out.println(rb);

        String message = rb.getString("wel.msg");

        Assert.assertEquals("Welcome!", message);

        System.out.println(message);
    }

    @Test
    public void readPropertiesWithWildcard() {
        ResourceBundle rb = ResourceBundle.getBundle("property_read/message");
        System.out.println(rb);

        String message = rb.getString("wel.msg");

        Assert.assertEquals("Default Welcome <{0}>!", message);

        System.out.println(MessageFormat.format(message, "Mr.John"));
    }
}
