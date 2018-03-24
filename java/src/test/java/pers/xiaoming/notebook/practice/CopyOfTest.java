package practice;

import java.util.Arrays;

public class CopyOfTest {
    public static void main(java.lang.String args[]) {
        Integer[] arr = {1,2,3,4};
//        Integer[] arr2 = Arrays.copyOf(arr, 10);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(arr2));

        // the memory address of these two arraies

        Object[] strArr = new Object[10];
        Class clazz = strArr.getClass();

        Object[] strArr2 = Arrays.copyOf(arr, 10, clazz);
        System.out.println(Arrays.toString(strArr2));
    }
}
