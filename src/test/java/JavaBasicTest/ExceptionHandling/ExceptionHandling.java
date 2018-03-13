package JavaBasicTest.ExceptionHandling;

public class ExceptionHandling {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        ArryWithException a = new ArryWithException();
        try {
            a.method(arr, 5);
        } catch (Exception e) {
            System.out.println(" *** !!! main catch catch exception from method");


            // if throw non runtime exception here
            // the main method need add throws at signature
//            throw new NegativeIndexException("");
        }

        try {
            a.tryMethod(arr, 10);
        } catch (Exception e) {
            System.out.println(" *** !!! main catch catch runtimeException from try method");

            System.out.println();
            System.out.println("Exception functions:  ");
            System.out.println("Exception get message:  " + e.getMessage());
            System.out.println("Exception to String:  " + e.toString());
            System.out.println("Exception get class:  " + e.getClass());
            System.out.println("Exception get stack trace:  " + e.getStackTrace());
            System.out.println();
            System.out.println("Exception print stack trace:  " );
            e.printStackTrace();
            System.out.println();
            System.out.println("Exception functions end");
            System.out.println();

            // the main method doesn't need add throws at signature,
            // because this is a runtime exception
            throw new NegativeIndexRuntimeException("try method throw exception");

            // This line never reach
//            System.out.println("Unreachable line");
        } finally {
            System.out.println(" *** !!! try method finally execute");
        }
    }
}

class ArryWithException {
    int method(int[] arr, int index) throws NegativeIndexException {
        return arr[index];
    }

    int tryMethod(int[] arr, int index) {
        return arr[index];
    }
}


class NegativeIndexException extends Exception {
    public NegativeIndexException(String msg) {
        super(msg);
    }
}

class NegativeIndexRuntimeException extends RuntimeException {
    NegativeIndexRuntimeException(String msg) {
        super(msg);
    }
}
