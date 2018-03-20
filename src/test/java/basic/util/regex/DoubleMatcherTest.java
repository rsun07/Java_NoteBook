package basic.util.regex;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;


@RunWith(Parameterized.class)
public class DoubleMatcherTest {
    private PatternMatcher matcher;

    @Before
    public void setUp() {
        matcher = new DoubleMatcher();
    }

    private String input;
    private boolean expect;

    @Parameterized.Parameters
    public static Collection<?> prepareDate() {
        Object[][] inputs = {
                {"0", true},
                {"80", true},
                {"8", true},
                {"0.8", true},
                {"8.0", true},
                {"8.8", true},
                {"800.08", true},
                {"8.00000000", true},
                {"8.00000008", true},
                {"0.00000008", true},
                {"00", false},
                {"08", false},
                {"8.", false},
                {"8.8.8", false},
                {"8..8", false},
                {".8", false},
                {"..8", false},
                {"00.8", false},
        };
        return Arrays.asList(inputs);
    }

    public DoubleMatcherTest(String input, boolean expect) {
        this.input = input;
        this.expect = expect;
    }

    @Test
    public void test() {
        Assert.assertThat(matcher.match(input), is(expect));
    }
}
