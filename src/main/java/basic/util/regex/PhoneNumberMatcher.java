package basic.util.regex;

/**
 *
 * Phone number format:
 * 1. without area code, only 7-8 number digits
 *    cannot start with 0
 *  Example: 4567890
 * 2. with area code and a slash between area code and number
 *    area code could start with 0, cannot be all 0
 *  Example: 123-456789
 * 3. area code with bracket
 *  Example: [123]-456789
 *
 */
class PhoneNumberMatcher extends PatternMatcherImpl {

    /*
     * Problem solving steps:
     * 1. Solving the format 1 first, then iterate.
     *   digit_pattern = [1-9][0-9]{6,7}
     * 2. Add area code
     *   [0-9]*[1-9][0-9]* this represents any digit, cannot all 0. But hard to restrict 3, 4 digits in total
     *   area_code_pattern = (((?!000)\d{3})|(?!0000)\d{4})
     *   pattern = area_code_pattern + digit_pattern
     * 3. Add bracket
     *   Be careful, both bracket must appear at the same time.
     *   ((\\[{area_code_pattern}\\])|{area_code_pattern})-)? + {digit_pattern}
     *
     */
    private static final String DIGIT_PATTERN = "[1-9][0-9]{6,7}";
    private static final String AREA_CODE_PATTERN = "(((?!000)\\d{3})|(?!0000)\\d{4})";
    private static final String PATTERN = String.format("(((\\[%s\\])|%s)-)?%s", AREA_CODE_PATTERN, AREA_CODE_PATTERN, DIGIT_PATTERN);

    PhoneNumberMatcher() {
        super(PATTERN);
    }
}
