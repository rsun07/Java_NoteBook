package pers.xiaoming.notebook.basic.util.regex.basic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;

@RunWith(Parameterized.class)
public class PhoneNumberTest extends RegexParameterizedTestBase {

    public PhoneNumberTest(String input, boolean expect) {
        super(input, expect);
    }

    @Before
    public void setUp() {
        this.matcher = new PhoneNumberMatcher();
    }



    @Parameterized.Parameters
    public static Collection<?> prepareDate() {
        Object[][] inputs = {
                // without area code
                {"4567890", true},
                {"45678900", true},
                {"456789000", false},
                {"456789", false},

                // area code without bracket
                {"123-4567890", true},
                {"0123-4567890", true},
                {"01234567890", false},
                {"00123-4567890", false},
                {"01-4567890", false},
                {"000-4567890", false},
                {"0000-4567890", false},
                {"0123-456-7890", false},
                {"0123--4567890", false},
                {"-0123-4567890", false},
                {"01-23-4567890", false},

                // area code with bracket
                {"[123]-4567890", true},
                {"[1230]-4567890", true},
                {"[123-4567890", false},
                {"123]-4567890", false},
                {"[123]4567890", false},
                {"[123] 4567890", false},
                {"[12300]-4567890", false},
                {"[123]-456789000", false},
                {"(123)-4567890", false},
                {"{123}-4567890", false},
                {"[123]--4567890", false},
                {"[12-30]-4567890", false},
                {"123-[4567890]", false},
                {"123-[456]7890", false},

        };
        return Arrays.asList(inputs);
    }

    @Test
    public void test() {
        Assert.assertThat(matcher.match(input), is(expect));
    }
}
