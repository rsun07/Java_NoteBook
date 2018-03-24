package basic.util.regex.basic;

class DoubleMatcher extends PatternMatcherImpl {
    /*
     * The Pattern can be also write as: "(0|([1-9]\\d*))(\\.\\d+)?"
     *
     * Mistake I made:
     *
     * 0|[1-9][0-9]*(\\.[0-9]+)?
     *    In this case, it means (0) or ([1-9][0-9]*(\\.[0-9]+)?)
     *
     */
    private static final String DOUBLE_PATTERN = "(0|[1-9][0-9]*)(\\.[0-9]+)?";

    private static final String DOUBLE_PATTERN_ALTERNATIVE = "(0|[1-9]\\d*)(\\.\\d+)?";

    DoubleMatcher() {
        super(DOUBLE_PATTERN);
    }
}
