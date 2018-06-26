package pers.xiaoming.notebook.lang.classloader;

import org.junit.Ignore;
import org.junit.Test;

@Ignore("Ignore for now")
public class PathClassLoaderTest {
    private static final String PACKAGE_PATH = "pers.xiaoming.notebook.entity";
    private static final String CLASS_PATH = "pers.xiaoming.notebook";

    @Test
    public void test() throws ClassNotFoundException {
        String className = ".Person";
        PathClassLoader classLoader = new PathClassLoader(PACKAGE_PATH + className, PACKAGE_PATH);
        Class personClass = classLoader.findClass(PACKAGE_PATH + className);
        System.out.println(personClass.getClassLoader());
    }
}
