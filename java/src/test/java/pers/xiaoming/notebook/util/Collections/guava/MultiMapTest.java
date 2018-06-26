package pers.xiaoming.notebook.util.Collections.guava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;
import java.util.Random;

@Ignore("Demo test")
// Multimap is not a map, it does NOT implement Java Map interface
public class MultiMapTest {
    private static Multimap<String, Integer> listMap;
    private static Multimap<String, Integer> setMap;
    private static Multimap<String, Integer> sortedSetMap;

    @BeforeClass
    public static void setup() {
        listMap = ArrayListMultimap.create();
        setMap = HashMultimap.create();
        sortedSetMap = TreeMultimap.create();

        prepareData();
    }

    private static void prepareData() {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int numValue = random.nextInt(3) + 1;
            String key = String.valueOf((char)('a' + i));
            for (int j = 0; j < numValue; j ++) {
                int value = random.nextInt(10);
                listMap.put(key, value);
                setMap.put(key, value);
                sortedSetMap.put(key, value);
            }
        }
    }

    @Test
    public void printMaps() {
        System.out.println("\nPrint list map:");
        printMap(listMap);
        System.out.println("\nPrint set map:");
        printMap(setMap);
        System.out.println("\nPrint sorted set map:");
        printMap(sortedSetMap);
    }

    private void printMap(Multimap<?, ?> multimap) {
        for (Map.Entry<?, ?> entry: multimap.entries()) {
            System.out.printf("Key is : %s; Value is : %s;\n", entry.getKey(), entry.getValue());
        }
    }
}
