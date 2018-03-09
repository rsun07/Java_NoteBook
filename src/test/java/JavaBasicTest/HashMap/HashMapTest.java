package java.JavaBasicTest.HashMap;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    private Map<Integer, Integer> map = new HashMap<>();

    public static void main(String args[]) {
        HashMapTest test = new HashMapTest();
        test.run();
    }

    private void run() {
        map.put(1, 1);
        map.put(2, 2);
        for (int i : map.keySet()) {
            System.out.println(i);
        }
    }
}
