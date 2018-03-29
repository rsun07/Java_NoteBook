package pers.xiaoming.notebook.basic.io.serialization;

import pers.xiaoming.notebook.basic.io.Utils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SerializationTest {
    private static final String FILE_PATH = Utils.SERIALIZATION_FILE_PATH + Utils.SERIALIZATION_FILE_NAME;

    @Before
    @After
    public void cleanSerializedFile() {
        File file = new File(FILE_PATH);
        file.deleteOnExit();
    }

    @Test
    public void testSerializeString() throws IOException, ClassNotFoundException {
        String string = "test string";

        ObjectSerializer.serialize(string, FILE_PATH);

        String result = "";

        result = ObjectSerializer.deserialize(result, FILE_PATH);

        Assert.assertEquals(string, result);
    }

    @Test
    public void testSerializeArray() throws IOException, ClassNotFoundException {
        int[] ints = {1, 2, 3, 4, 5};

        ObjectSerializer.serialize(ints, FILE_PATH);

        int[] result = new int[0];

        result = ObjectSerializer.deserialize(result, FILE_PATH);

        Assert.assertArrayEquals(ints, result);
    }

    @Test
    public void testSerializeCollection() throws IOException, ClassNotFoundException {
        Map<String, List<Double>> map = new HashMap<>();
        map.put("1", new ArrayList<>());
        map.put("2", Arrays.asList(3.3, 2.8, 1.8, 1.6));

        ObjectSerializer.serialize(map, FILE_PATH);

        Map<String, List<Double>> result = new HashMap<>();

        result = ObjectSerializer.deserialize(result, FILE_PATH);

        Assert.assertEquals(map, result);
    }

    @Test
    public void testSerializeTransient() throws IOException, ClassNotFoundException {
        MySerializableObject object = new MySerializableObject("Object Ser", 2, 10000);

        ObjectSerializer.serialize(object, FILE_PATH);

        MySerializableObject result = new MySerializableObject();

        //salary field is transient, cannot be serialized.
        object.setSalary(0);

        result = ObjectSerializer.deserialize(result, FILE_PATH);

        Assert.assertEquals(object, result);
    }
}
