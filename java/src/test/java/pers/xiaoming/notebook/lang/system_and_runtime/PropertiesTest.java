package pers.xiaoming.notebook.lang.system_and_runtime;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;
import java.util.Properties;

public class PropertiesTest {
    @Test
    @Ignore("Demo print output test")
    public void test() {
        // properties is a subclass of HashTable
        Properties properties = System.getProperties();
        for (Map.Entry entry : properties.entrySet()) {
            System.out.println(entry.getKey() + "\t\t\t\t\t : " + entry.getValue());
        }
    }
}
