package pers.xiaoming.notebook.parameter;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
    @DataProvider(name = "add_test_data_provider")
    public Object[][] dataCreator() {
        return new Integer[][] {
                {1, 1, 2},
                {2, 1, 3},
                {7, 1, 8},
        };
    }

    @Test(dataProvider = "add_test_data_provider")
    public void test(int a, int b, int sum) {
        Assert.assertEquals(sum, a+b);
        System.out.println(a + " + " + b + " = " + sum);
    }

}
