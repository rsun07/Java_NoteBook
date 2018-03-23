package basic.util.regex.advanced_regex;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized;

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

    @Test
    public void testZeroWidthPositiveLookahead() {
        // pattern meaning: find \\d{2} where just followed by [a-z]{2}
        Pattern pattern = Pattern.compile("\\d{2}(?=[a-z]{2})");
        String input = "a18cc68eee";
        Matcher matcher = pattern.matcher(input);

        // must run matches() function before run group() function
        Assert.assertTrue(matcher.find());
        Assert.assertEquals("18", matcher.group());

        // must run find() function again to match the next group
        Assert.assertTrue(matcher.find());
        Assert.assertEquals("68", matcher.group());
    }

    // this test is to prove Zero Width Positive Lookahead is no capturing
    @Test
    public void testZeroWidthPositiveLookaheadForNoCapturingFeature() {
        Pattern pattern = Pattern.compile("\\w{2}(?=\\w{2})");
        String input = "88888888";
        Matcher matcher = pattern.matcher(input);

        int totalMatches = 0;
        while (matcher.find()) {
            Assert.assertEquals("88", matcher.group());
            totalMatches++;
        }

        // totally have 3 matches, which means
        // the first match find 88(88)
        // the second match start from the third 8 rather than the fifth 8
        // that's the meaning of "zero width"
        Assert.assertEquals(3, totalMatches);
    }

    @Test
    public void testZeroWidthPositiveLookaheadBefore() {
        // meaning here: could input matches [0-9]{2}?
        // If could, then please match the [a-z]{2} from the [0-9]{2}
        // Obviously, no match, because cannot find [a-z] from [0-9]
        Pattern pattern = Pattern.compile("(?=([0-9]{2}))[a-z]{2}");
        String input = "88ff88ff88";
        Matcher matcher = pattern.matcher(input);

        Assert.assertFalse(matcher.find());

        // find 'ff' from \\w{2} matches
        pattern = Pattern.compile("(?=\\w{2})ff");
        input = "88ff88dd8ff8";
        matcher = pattern.matcher(input);

        int totalMatches = 0;
        while (matcher.find()) {
            Assert.assertEquals("ff", matcher.group());
            totalMatches++;
        }

        Assert.assertEquals(2, totalMatches);
    }
}
