package basic.util.regex;

/**
 *
 * Email Format：
 * 1. user name and host server:
 *    - could be any English chars, numbers, underscore and dot
 *    - must start from char
 *    - cannot be ending with underscore or dot
 *    - at least 5 chars long and cannot be longer than 30 chars
 * 2. domain name:
 *    - must be ending in one of the following :
 *    .com, .cn, .net, .com.cn, .net.cn, .edu, .gov, .org
 *
 */

public class EmailMatcher extends PatternMatcherImpl {

    /*
     * for user name and host server name:
     * start [a-zA-Z]
     * end [a-zA-Z0-9]
     * middle, [a-zA-Z0-9]{3,28}
     *
     * for domain names:
     * (net|cn|com\\.cn|.net\\.cn|org|edu|gov)
     *
     */

    private static final String NAME_FIRST_CHAR = "[a-zA-Z]";
    private static final String NAME_MIDDLE_CHARS = "[a-zA-Z0-9]{3,28}";
    private static final String NAME_LAST_CHAR = "[a-zA-Z0-9]";
    private static final String NAME_PATTERN = NAME_FIRST_CHAR + NAME_MIDDLE_CHARS + NAME_LAST_CHAR;

    private static final String USER_NAME_PATTERN = NAME_PATTERN;
    private static final String SERVER_NAME_PATTERN = NAME_PATTERN;

    private static final String DOMAIN_NAME_PATTERN = "(net|cn|com\\.cn|.net\\.cn|org|edu|gov)";

    private static final String PATTERN = String.format(
            "%s@%s.%s", USER_NAME_PATTERN, SERVER_NAME_PATTERN, DOMAIN_NAME_PATTERN);

    EmailMatcher() {
        super(PATTERN);
    }
}
