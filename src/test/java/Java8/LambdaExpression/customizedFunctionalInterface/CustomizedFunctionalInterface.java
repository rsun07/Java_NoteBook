package Java8.LambdaExpression.customizedFunctionalInterface;

// The core of Lambda Expression is
// the implementation of the abstract function in a functional Interface

import org.junit.Before;
import org.junit.Test;

public class CustomizedFunctionalInterface {

    /**
     *
     * @param str the string that need to be operated
     * @param operation the customized implementation of the functional Interface.
     * @return
     */
    private String strHandler(String str, StrOperation operation) {
        return operation.strOperation(str);
    }

    private String inputStr = null;

    @Before
    public void before() {
        this.inputStr = " abc e d  \t";
    }

    @Test
    public void strTrimTraditional() {
        String result = strHandler(this.inputStr, new StrTrim());
        System.out.println(result);
    }

    @Test
    public void strTrimLambda() {
        String result = strHandler(this.inputStr, str -> str.trim());
        System.out.println(result);
    }

    @Test
    public void strTrimMethodReference() {
        String result = strHandler(this.inputStr, String::trim);
        System.out.println(result);
    }

    @Test
    public void toUpperCaseMethodReference() {
        String result = strHandler(this.inputStr, String::toUpperCase);
        System.out.println(result);
    }

    @Test
    public void strTrimAndToUpperCase() {
        String result = strHandler(this.inputStr, str -> str.trim().toUpperCase());
        System.out.println(result);
    }
}
