package basic.util.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapTest {

    @Test
    public void weakHashMapTest() throws InterruptedException {
        WeakHashMap<Integer, String> map = new WeakHashMap<>();
        map.put(1, "s");

        for (int i = 0; i < 10000; i++) {
            System.gc();
            if (map.size() != 0) {
                System.out.println("At iteration " + i + " the map still holds the reference on someDataObject");
            } else {
                System.out.println("somDataObject has finally been garbage collected at iteration " + i + ", hence the map is now empty");
                break;
            }
        }
    }

    @Test
    public void testMaps() throws InterruptedException {
        Map<String, String> hashMap= new HashMap<>();
        Map<String, String> weakHashMap = new WeakHashMap<>();

        String keyHashMap = "keyHashMap";
        String keyWeakHashMap = "keyWeakHashMap";

        hashMap.put(keyHashMap, "helloHash");
        weakHashMap.put(keyWeakHashMap, "helloWeakHash");
        System.out.println("Before: hash map value: "+hashMap.get("keyHashMap")+" and weak hash map value: "+weakHashMap.get("keyWeakHashMap"));

        keyHashMap = null;
        keyWeakHashMap = null;

        System.gc();
        Runtime.getRuntime().gc();
        Thread.sleep(5*1000);

        System.out.println("After: hash map value: "+hashMap.get("keyHashMap")+" and weak hash map value: "+weakHashMap.get("keyWeakHashMap"));
    }

    public static void main(String[] args) throws InterruptedException {
    }
}
