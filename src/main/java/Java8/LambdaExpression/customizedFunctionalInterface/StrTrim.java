package Java8.LambdaExpression.customizedFunctionalInterface;

class StrTrim implements StrOperation {
    @Override
    public String strOperation(String string) {
        return string.trim();
    }
}