package basic.util.regex.basic;

class PatternMatcherImpl implements PatternMatcher {
    private String pattern;

    PatternMatcherImpl(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public boolean match(String input) {
        return input.matches(pattern);
    }
}
