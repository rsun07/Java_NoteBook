package test;

import java.util.HashMap;
import java.util.Map;

public class StringTest {
    private Map<Integer, Integer> map = new HashMap<>();

    public static void main(java.lang.String args[]) {
        String testStr = "  a bc   ";
        testStr = testStr.trim();
        System.out.println(testStr);
    }

    private void run() {
        map.put(1, 1);
        map.put(2, 2);
        for (int i : map.keySet()) {
            System.out.println(i);
        }
    }
}
