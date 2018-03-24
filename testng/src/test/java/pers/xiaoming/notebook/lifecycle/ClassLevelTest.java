package pers.xiaoming.notebook.lifecycle;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pers.xiaoming.notebook.Singleton;

// If only run test here
// only beforeClass will run

// If need to run test in TestLevel or SuiteLevel
// need to run from xml
public class ClassLevelTest {
    @BeforeClass
    public void beforeClass() {
        System.out.println("Running before Class: \t\t Get already initialized Singleton: " + Singleton.getSingleton());
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Running before Method: \t\t Get already initialized Singleton: " + Singleton.getSingleton());
    }

    @Test
    public void test1() {
        System.out.println("Running Test 1: \t\t Get already initialized Singleton: " + Singleton.getSingleton());
    }

    @Test
    public void test2() {
        System.out.println("Running Test 2: \t\t Get already initialized Singleton: " + Singleton.getSingleton());
    }


    @AfterMethod
    public void afterMethod() {
        System.out.println("Running after Method.");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Running after Class.");
    }
}
