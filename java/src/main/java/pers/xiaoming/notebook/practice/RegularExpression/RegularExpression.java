package practice.RegularExpression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
    private static final String PATTERN = "[a-zA-Z0-9+\\/]{43}";

    private static final List<String> FAMILY_FRIENDLY_WORDS =
        new ArrayList<>(Arrays.asList("d[a4]mn"));

    public static void main(String[] args) {
        RegularExpression checkIt = new RegularExpression();
//        System.out.println(checkIt.test());
        checkIt.test();
    }

    private void
    parse() {
        String str1 = "i1YnGEIy2EBtADWycJb9y+yekYJPSS024uGwicSfzcM";
        String str2 = "i1YnGEIy2EBtADWycJb9y+yekYJPSS024uGwicSfzcM";
        String str3 = "MY/U11OJGl5fQO9XyXHruF/s2ZPl46bo6KTSRfBWR3w";

        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(str3);

        System.out.println(matcher.matches());
        System.out.println(Pattern.matches(PATTERN, str1));
    }

    private boolean check() {
        String str1 = "fuck";
        for (String word : FAMILY_FRIENDLY_WORDS) {
            if (Pattern.matches(word, str1)) {
                return false;
            }
        }
        return false;
    }

    private void test() {
        String str1 = "cuuuunt";
        System.out.println(Pattern.matches("c[*u]+nt", str1));
    }
}
