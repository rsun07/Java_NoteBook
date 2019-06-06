package pers.xiaoming.notebook.util.property_read;

import org.junit.Assert;
import org.junit.Test;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

public class PropertyFileTest {
    @Test
    public void readPropertiesFile() {
        // Don't need the ".properties" suffix
        // Must add the property file into CLASSPATH
        ResourceBundle rb = ResourceBundle.getBundle("pers.xiaoming.notebook.rxjava.helloworld");
        System.out.println(rb);

        String message = rb.getString("wel.msg");

        Assert.assertEquals("Welcome!", message);

        System.out.println(message);
    }

    @Test
    public void readPropertiesWithWildcard() {
        ResourceBundle rb = ResourceBundle.getBundle("pers.xiaoming.notebook.rxjava.helloworld");
        System.out.println(rb);

        String message = rb.getString("wel.wildcard");

        Assert.assertEquals("Welcome <{0}>!", message);

        System.out.println(MessageFormat.format(message, "Mr.John"));
    }

    @Test
    public void readPropertiesInfo() {
        ResourceBundle rb = ResourceBundle.getBundle("pers.xiaoming.notebook.rxjava.helloworld");

        Set<String> expectKeySet = new HashSet<>(Arrays.asList("wel.wildcard", "wel.msg"));
        Assert.assertEquals(expectKeySet, rb.keySet());
        System.out.println(rb.keySet());

        Assert.assertEquals("pers.xiaoming.notebook.rxjava.helloworld", rb.getBaseBundleName());
        System.out.println(rb.getBaseBundleName());
    }
}
