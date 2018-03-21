package basic.util.regex;

public class RegexParameterizedTestBase {
    String input;
    boolean expect;

    PatternMatcher matcher;

    RegexParameterizedTestBase(String input, boolean expect) {
        this.input = input;
        this.expect = expect;
    }
}
