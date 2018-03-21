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
public class EmailMatcherTest extends RegexParameterizedTestBase {
    public EmailMatcherTest(String input, boolean expect) {
        super(input, expect);
    }

    @Before
    public void setUp() {
        matcher = new EmailMatcher();
    }

    @Parameterized.Parameters
    public static Collection<?> prepareDate() {
        Object[][] inputs = {
                {"a123@a123.com", true},

                {"a_123@a123.com", true},
                {"a123@a_123.com", true},
                {"a1_23@a123.com", true},
                {"a123@a1_23.com", true},

                {"a12.3@a12.3.com", true},
                {"a.123@a.123.com", true},

                {"a+123@a123.com", true},
                {"a123@a+123.com", true},

                {"a123@a123.com", true},
                {"a123@a123.com.cn", true},
                {"a123@a123.net", true},
                {"a123@a123.net.cn", true},
                {"a123@a123.org", true},
                {"a123@a123.gov", true},


                // invalid cases
                {"123@a123.com", false},
                {"a123@123.com", false},
                {"a123_@a123.com", false},
                {"a123@a123_.com", false},
                {"a123+@a123.com", false},
                {"a123@a123+.com", false},

                {"a1@a123.com", false},
                {"a123@a1.com", false},

                {"a-123@a123.com", false},
                {"a123@a-123.com", false},

                {"a123@a123..com", false},
                {"a123.@a123.com", false},

                {"abcdefghijklmnopqrstuvwxyz0123456789@a123.com", false},
                {"a123@abcdefghijklmnopqrstuvwxyz0123456789.com", false},

                {"a123@a123.me", false},
                {"a123@a123.cn.com", false},

        };
        return Arrays.asList(inputs);
    }

    @Test
    public void test() {
        Assert.assertThat(matcher.match(input), is(expect));
    }
}
