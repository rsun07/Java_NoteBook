package Junit.Junit4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

// If don't Run with Parameterized,
// System will run with Junit by default,
// which won't apply all the inputs
@RunWith(Parameterized.class)
public class ParameterizedTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("\n\nRunning Parameterized Test\n");
    }

    private int expected;
    private int input1;
    private int input2;

    @Parameterized.Parameters
    public static Collection<?> prepareData() {
        Integer[][] inputs = {
                {3,1,2},
                {2,1,1},
                {5,2,3},
                {8,6,2}
        };
        return Arrays.asList(inputs);
    }

    public ParameterizedTest(int expected, int input1, int input2) {
        this.expected = expected;
        this.input1 = input1;
        this.input2 = input2;
    }

    @Test
    public void testAdd() {
        System.out.printf("The expected value is %d, input1 is %d, input2is %d\n\n", expected, input1, input2);
        Assert.assertEquals(expected, input1 + input2);
    }
}
