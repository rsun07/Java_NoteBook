package pers.xiaoming.notebook.basic.util.map;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    @Test
    public void testContains() {
        Set<MyObject> set = new HashSet<>();
        MyObject object1 = new MyObject("object1", 1);
        MyObject object2 = new MyObject("object2", 2);
        MyObject object3 = new MyObject("object3", 3);
        set.add(object1);
        set.add(object2);
        set.add(object3);


        Set<MyObject> copySet = new HashSet<>();
        MyObject copy1 = new MyObject("object1", 1);
        MyObject copy2 = new MyObject("object2", 2);
        copySet.add(copy1);
        copySet.add(copy2);

        Assert.assertTrue(set.contains(copy1));
        Assert.assertTrue(set.containsAll(copySet));
    }
}
