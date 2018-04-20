package pers.xiaoming.notebook.util.regex.basic;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Pattern;

public class PatternTest {
    @Test
    public void testPatternSplit() {
        Pattern pattern = Pattern.compile("\\d");
        String input = "a1b2c";
        String[] result = pattern.split(input);
        String[] expect = {"a", "b", "c" };
        Assert.assertArrayEquals(expect, result);
    }

    @Test
    public void testPatternSplitWithEmptyResult() {
        Pattern pattern = Pattern.compile("\\d");
        String input = "a12b23c";
        String[] result = pattern.split(input);
        String[] expect = {"a", "", "b", "", "c" };
        Assert.assertArrayEquals(expect, result);
    }

    @Test
    public void testStringSplit() {
        String input = "a12b23c";
        String[] result = input.split("\\d");
        String[] expect = {"a", "", "b", "", "c" };
        Assert.assertArrayEquals(expect, result);
    }
}
