package pers.xiaoming.notebook.basic.util.regex.basic;

/**
 *
 * Email Format：
 * 1. user name and host server:
 *    - could be any English chars, numbers, underscore and dot
 *    - must start from char
 *    - cannot be ending with underscore or dot
 *    - at least 3 chars long and cannot be longer than 30 chars
 *    - host name cannot include domain name but user name can
 * 2. domain name:
 *    - must be ending in one of the following :
 *    .com, .cn, .net, .com.cn, .net.cn, .edu, .gov, .org
 *
 */

class EmailMatcher extends PatternMatcherImpl {

    /*
     * for user name and host server name:
     * start [a-zA-Z]
     * end [a-zA-Z0-9]
     * middle, [a-zA-Z0-9]{3,28}
     *
     * for domain names:
     * (net|com|cn|com\\.cn|.net\\.cn|org|edu|gov)
     *
     */

    private static final String NAME_FIRST_CHAR = "[a-zA-Z]";
    private static final String NAME_MIDDLE_CHARS = "[a-zA-Z0-9_\\+\\.]{1,28}";
    private static final String NAME_LAST_CHAR = "[a-zA-Z0-9]";
    private static final String NAME_PATTERN = NAME_FIRST_CHAR + NAME_MIDDLE_CHARS + NAME_LAST_CHAR;

    private static final String USER_NAME_PATTERN = NAME_PATTERN;

    private static final String DOMAIN_NAME_PATTERN = "(net|com|cn|com\\.cn|.net\\.cn|org|edu|gov)";

    private static final String SERVER_NAME_PATTERN = String.format("(?!%s)%s", DOMAIN_NAME_PATTERN, NAME_PATTERN);

    private static final String PATTERN = String.format(
            "%s@%s\\.%s", USER_NAME_PATTERN, SERVER_NAME_PATTERN, DOMAIN_NAME_PATTERN);

    EmailMatcher() {
        super(PATTERN);
    }
}
