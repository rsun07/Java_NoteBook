package basic.util.regex.advanced_regex;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternAndMatcherTest {
    @Test
    public void testMatches() {
        Pattern pattern = Pattern.compile("\\d+");
        String input = "18";
        Matcher matcher = pattern.matcher(input);

        Assert.assertTrue(matcher.matches());
    }

    @Test
    public void testGetPatternAndChangePattern() {
        Pattern pattern = Pattern.compile("\\d+");
        String input = "18";
        Matcher matcher = pattern.matcher(input);

        Assert.assertEquals(pattern, matcher.pattern());

        Pattern newPattern = Pattern.compile("\\s+");
        matcher.usePattern(newPattern);

        Assert.assertEquals(newPattern, matcher.pattern());
    }

    @Test
    public void testFindSubsequence() {
        Pattern pattern = Pattern.compile("\\d");
        String input = "a1cc8eee";
        Matcher matcher = pattern.matcher(input);

        Assert.assertFalse(matcher.matches());

        // find the next subsequence
        Assert.assertTrue(matcher.find());

        // find next subsequence starting from index
        Assert.assertFalse(matcher.find(6));
    }

    @Test
    public void testMatcherGroup() {
        Pattern pattern = Pattern.compile("\\w*(\\d)([a-z]{2})\\w*");
        String input = "a1cc";
        Matcher matcher = pattern.matcher(input);

        // must run matches() function before run group() function
        Assert.assertTrue(matcher.matches());

        Assert.assertEquals("a1cc", matcher.group(0));
        Assert.assertEquals("1", matcher.group(1));
        Assert.assertEquals("cc", matcher.group(2));
    }

    @Test
    public void testMatcherMultiGroup() {
        Pattern pattern = Pattern.compile("\\w*(\\d)([a-z]{2})\\w*");
        String input = "a1cc8eee";
        Matcher matcher = pattern.matcher(input);

        Assert.assertTrue(matcher.matches());

        // just skip "1cc" matches the last groups
        Assert.assertEquals("a1cc8eee", matcher.group(0));
        Assert.assertEquals("8", matcher.group(1));
        Assert.assertEquals("ee", matcher.group(2));
    }

    @Test
    public void testMatcherRegion() {
        Pattern pattern = Pattern.compile("\\w*(\\d)([a-z]{2})\\w*");
        String input = "a1cc8eee";
        Matcher matcher = pattern.matcher(input);

        matcher.region(0, 4);
        Assert.assertTrue(matcher.matches());

        // restrict the region for match
        Assert.assertEquals("a1cc", matcher.group(0));
        Assert.assertEquals("1", matcher.group(1));
        Assert.assertEquals("cc", matcher.group(2));

        Assert.assertEquals(0, matcher.regionStart());
        Assert.assertEquals(4, matcher.regionEnd());
    }

    @Test
    public void testReplaceFirst() {
        // In this case, the Pattern should only be the pattern you want to replace!!
        // comparing with the previous pattern, "\\w*" are removed
        Pattern pattern = Pattern.compile("\\d[a-z]{2}");
        String input = "a1ccdd8eee";
        Matcher matcher = pattern.matcher(input);

        String result = matcher.replaceFirst("***");

        Assert.assertEquals("a***dd8eee", result);
    }

    @Test
    public void testReplaceAll() {
        Pattern pattern = Pattern.compile("\\d[a-z]{2}");
        String input = "a1ccdd8eee";
        Matcher matcher = pattern.matcher(input);

        String result = matcher.replaceAll("***");

        Assert.assertEquals("a***dd***e", result);
    }
}
