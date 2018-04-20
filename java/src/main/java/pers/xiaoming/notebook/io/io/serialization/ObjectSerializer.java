package pers.xiaoming.notebook.io.io.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerializer {
    static void serialize(Object object, String destFilePath) throws IOException {
        ObjectOutputStream serializeStream = new ObjectOutputStream(
                new FileOutputStream(new File(destFilePath)));

        System.out.printf("Serializing input <%s> to file '%s'\n\n",
                object.getClass().getName(), destFilePath);

        serializeStream.writeObject(object);
        serializeStream.close();

        System.out.println("\nSerialization Success!");
    }

    @SuppressWarnings("unchecked")
    static <T> T deserialize(T receiverObj, String sourceFilePath) throws IOException, ClassNotFoundException {
        ObjectInputStream deserializeStream = new ObjectInputStream(
                new FileInputStream(new File(sourceFilePath)));

        System.out.printf("Deserializing Object <%s> from file %s\n\n",
                receiverObj.getClass().getName(), sourceFilePath);

        T t = (T) deserializeStream.readObject();
        deserializeStream.close();

        System.out.println("\nDeserialization Success!");
        return t;
    }
}
