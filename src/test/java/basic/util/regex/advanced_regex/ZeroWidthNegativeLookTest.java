package basic.util.regex.advanced_regex;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZeroWidthNegativeLookTest {
    @Test
    public void testZeroWidthNegativeLookahead() {
        // pattern meaning: find \\d{2} where NOT followed by [a-z]{2}
        Pattern pattern = Pattern.compile("\\d{2}(?![a-z]{2})");
        String input = "a18b28c68eee";
        Matcher matcher = pattern.matcher(input);

        // must run matches() function before run group() function
        Assert.assertTrue(matcher.find());
        Assert.assertEquals("18", matcher.group());

        // must run find() function again to match the next group
        Assert.assertTrue(matcher.find());
        Assert.assertEquals("28", matcher.group());
    }


    @Test
    public void testZeroWidthNegativeLookBehind() {
        // pattern meaning: find \\d{2} where NOT behind [a-z]{2}
        Pattern pattern = Pattern.compile("(?<![a-z]{2})\\d{2}");
        String input = "a18bb28c68eee";
        Matcher matcher = pattern.matcher(input);

        // must run matches() function before run group() function
        Assert.assertTrue(matcher.find());
        Assert.assertEquals("18", matcher.group());

        // must run find() function again to match the next group
        Assert.assertTrue(matcher.find());
        Assert.assertEquals("68", matcher.group());
    }
}
