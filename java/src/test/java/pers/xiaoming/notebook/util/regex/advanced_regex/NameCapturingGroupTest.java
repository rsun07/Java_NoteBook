package pers.xiaoming.notebook.util.regex.advanced_regex;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameCapturingGroupTest {
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

        // matches the last group by default
        Assert.assertEquals("a18cc18eee", matcher.group(0));
        Assert.assertEquals("a18cc", matcher.group(1));
        Assert.assertEquals("eee", matcher.group(2));
    }

    // Non capturing group doesn't work in find() and group() strategy
    @Test
    public void testNonCapturingGroupSubSequence() {
        Pattern pattern = Pattern.compile("(\\w{1})(?:\\d{2})(\\w{2})");
        String input = "a18cc18eee";
        Matcher matcher = pattern.matcher(input);

        // must run find() function before run group() function
        Assert.assertTrue(matcher.find());
        Assert.assertEquals("a18cc", matcher.group());

        // must run find() function again to match the next group
        // cannot find the next match because the 'c' char is already used in previous match
        Assert.assertFalse(matcher.find());


        // change another input
        matcher = pattern.matcher("a18ccd18eee");

        Assert.assertTrue(matcher.find());
        Assert.assertEquals("a18cc", matcher.group());

        Assert.assertTrue(matcher.find());
        Assert.assertEquals("d18ee", matcher.group());
    }

}
