package JavaTest.JavaBasicTest.Stream.Advanced;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class groupingBy_partitioningBy_Test {

    private Map<Integer, String> initialMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "a");
        map.put(5, "b");
        map.put(6, "a");
        return map;
    }

    @Test
    public void testMapStream() {
        Map<Integer, String> map = initialMap();

        map.entrySet().stream()
                .filter(entry -> entry.getKey() > 3)
                .forEach(System.out::println);
    }

    @Test
    public void testGroupingBy() {
        Map<Integer, String> map = initialMap();

        // group the map entry by the map's key.
        // the return value, the key will be the map value and the value will be a list of map entry
        Map<String, List<Map.Entry<Integer, String>>> result =
            map.entrySet().stream()
                    .collect(Collectors.groupingBy(Map.Entry<Integer, String>::getValue));
        System.out.println(result);
    }

    @Test
    public void testPartitioningBy() {
        Map<Integer, String> map = initialMap();

        Map<Boolean, List<Map.Entry<Integer, String>>> result =
                map.entrySet().stream()
                        .collect(Collectors.partitioningBy((Map.Entry<Integer, String> entry) -> entry.getKey() > 3));
        System.out.println(result);
    }
}
