package pers.xiaoming.notebook.util.map;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    @Test
    public void testContains() {
        Map<MyObject, Object> map = new HashMap<>();
        MyObject object = new MyObject("object", 1);
        MyObject copy = new MyObject("object", 1);

        map.put(object, null);

        Assert.assertTrue(map.containsKey(copy));
    }
}
