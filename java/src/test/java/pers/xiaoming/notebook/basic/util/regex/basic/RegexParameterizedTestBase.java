package pers.xiaoming.notebook.basic.util.regex.basic;


class RegexParameterizedTestBase {
    String input;
    boolean expect;

    PatternMatcher matcher;

    RegexParameterizedTestBase(String input, boolean expect) {
        this.input = input;
        this.expect = expect;
    }
}
