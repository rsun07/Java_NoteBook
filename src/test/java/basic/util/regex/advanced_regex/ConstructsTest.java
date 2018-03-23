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

    @Test
    public void testNonCapturingGroup() {
        Pattern pattern = Pattern.compile("(\\w*)(?:\\d{2})(\\w*)");
        String input = "a18cc8eee";
        Matcher matcher = pattern.matcher(input);

        // must run matches() function before run group() function
        Assert.assertTrue(matcher.matches());

        Assert.assertEquals("a18cc8eee", matcher.group(0));
        Assert.assertEquals("a", matcher.group(1));
        Assert.assertEquals("cc8eee", matcher.group(2));
    }

    @Test
    public void testNonCapturingGroupMultiMatches() {
        Pattern pattern = Pattern.compile("(\\w*)(?:\\d{2})(\\w*)");
        String input = "a18cc18eee";
        Matcher matcher = pattern.matcher(input);

        // must run matches() function before run group() function
        Assert.assertTrue(matcher.matches());

        // matches the last group
        Assert.assertEquals("a18cc18eee", matcher.group(0));
        Assert.assertEquals("a18cc", matcher.group(1));
        Assert.assertEquals("eee", matcher.group(2));
    }

//    @Test
//    public void testNonCapturingGroup() {
//        Pattern pattern = Pattern.compile("(\\w*)(?:\\d{2})(\\w*)");
//        String input = "a18cc8eee";
//        Matcher matcher = pattern.matcher(input);
//
//        // must run matches() function before run group() function
//        Assert.assertTrue(matcher.matches());
//
//        Assert.assertEquals("a18cc8eee", matcher.group(0));
//        Assert.assertEquals("a", matcher.group(1));
//        Assert.assertEquals("cc8eee", matcher.group(2));
//    }
}
