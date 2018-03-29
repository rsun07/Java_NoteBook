package pers.xiaoming.notebook.basic.util.regex.advanced_regex;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZeroWidthPositiveLookTest {
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
        wrongMeaningTest();
        findWordsFromChars();
        findDigitFromChars();
    }

        private void wrongMeaningTest() {
            // meaning here: could input matches [0-9]{2}?
            // If could, then please match the [a-z]{2} from the [0-9]{2}
            // Obviously, no match, because cannot find [a-z] from [0-9]
            Pattern pattern = Pattern.compile("(?=([0-9]{2}))[a-z]{2}");
            String input = "88ff88ff88";
            Matcher matcher = pattern.matcher(input);

            Assert.assertFalse(matcher.find());
        }

        private void findWordsFromChars() {
            // find 'ff' from \\w{2} matches
            Pattern pattern = Pattern.compile("(?=\\w{2})ff");
            String input = "88ff88dd8ff8";
            Matcher matcher = pattern.matcher(input);

            int totalMatches = 0;
            while (matcher.find()) {
                Assert.assertEquals("ff", matcher.group());
                totalMatches++;
            }

            Assert.assertEquals(2, totalMatches);
        }

        private void findDigitFromChars() {
            // find \d{2} from \w{2} matches
            Pattern pattern = Pattern.compile("(?=\\w{2})\\d{2}");
            String input = "88888888";
            Matcher matcher = pattern.matcher(input);

            int totalMatches = 0;
            while (matcher.find()) {
                Assert.assertEquals("88", matcher.group());
                totalMatches++;
            }

            Assert.assertEquals(4, totalMatches);
        }

    @Test
    public void testZeroWidthPositiveLookBehind() {
        // pattern meaning: find \\d{2} where just behind [a-z]{2}
        Pattern pattern = Pattern.compile("(?<=[a-z]{2})\\d{2}");
        String input = "a18bb28cc68eee";
        Matcher matcher = pattern.matcher(input);

        // must run matches() function before run group() function
        Assert.assertTrue(matcher.find());
        Assert.assertEquals("28", matcher.group());

        // must run find() function again to match the next group
        Assert.assertTrue(matcher.find());
        Assert.assertEquals("68", matcher.group());
    }

    @Test
    public void testZeroWidthPositiveLookBehindForNoCapturing() {
        // pattern meaning: find \\d{2} where just behind [a-z]{2}
        Pattern pattern = Pattern.compile("(?<=\\d{2})\\d{2}");
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
}
