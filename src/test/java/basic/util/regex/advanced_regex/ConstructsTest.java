package basic.util.regex.advanced_regex;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConstructsTest {
    @Test
    public void testNamedCapturingGroup() {
        Pattern pattern = Pattern.compile("\\w*(?<twodigits>\\d{2})\\w*");
        String input = "a18cc8eee";
        Matcher matcher = pattern.matcher(input);

        // must run matches() function before run group() function
        Assert.assertTrue(matcher.matches());

        Assert.assertEquals("18", matcher.group("twodigits"));
    }
}
