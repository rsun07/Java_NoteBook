package java8.lambda.customized_functional_interface;

class StrTrim implements StrOperation {
    @Override
    public String strOperation(String string) {
        return string.trim();
    }
}