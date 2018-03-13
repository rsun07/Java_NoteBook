package JavaBasicTest.GenericType;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericType {
    public static void main(String args[]) {
        MyGenericType<String> stringMyGenericType = new MyGenericType<>();

        stringMyGenericType.genericMethod("AA");
        stringMyGenericType.genericInputMethod(new Integer(7));

        MyGenericType.genericStaticMethod(true);
    }

    @Test
    public void testLiskovSubstitutionPrincipal() {
        List<String> stringList = new ArrayList<>();

        // List<String> is not a subtype of List<Object>
        // Based on Liskov Substitution Principal, subtype can substitute super type
        // still confused

        //System.out.println(new ArrayList<String>() instanceof List<Object>);


        // For Array it works fine.
        // Array types are covariant
        System.out.println(new String[2] instanceof Object[]);

    }
}

class MyGenericType<QQ> implements Comparable<QQ> {

    void genericMethod (QQ qq) {
        printClassName("QQ", qq.getClass());
    }

    <YY> void genericInputMethod (YY yy) {
        printClassName("YY", yy.getClass());
    }

    static <ZZ> void genericStaticMethod (ZZ zz) {
        printClassName("ZZ", zz.getClass());
    }


    @Override
    public int compareTo(QQ o) {
        return 0;
    }

    private static void printClassName (String genericName, Class clazz) {
        System.out.println("Static : " + genericName +" is a \"" + clazz.getName() + "\" class");
    }
}
