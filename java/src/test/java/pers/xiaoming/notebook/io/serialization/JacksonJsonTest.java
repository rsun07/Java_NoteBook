package pers.xiaoming.notebook.io.serialization;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Assert;
import org.junit.Test;
import pers.xiaoming.notebook.io.Utils;
import pers.xiaoming.notebook.io.serialization.entity.PersonJson;

import java.io.File;
import java.io.IOException;

public class JacksonJsonTest {
    private final static PersonObjectMapper<PersonJson> OBJECT_MAPPER = new PersonObjectMapper<>(new XmlMapper(), PersonJson.class);
    private PersonJson person = new PersonJson("myName", 23, 5000, "310-000-0000");

    // <PersonXML name="myName" age="23" xmlns:wstxns1="phone_number" wstxns1:phoneNum="310-000-0000"><salary>5000</salary></PersonXML>
    @Test
    public void objectToXMLStringTest() throws IOException {
        String jsonString = OBJECT_MAPPER.serialize(person);
        System.out.println(jsonString);

        PersonJson personFromJson = OBJECT_MAPPER.deserialize(jsonString);
        Assert.assertNotSame(person, personFromJson);
        Assert.assertEquals(person, personFromJson);
    }

    private final static String XML_SERIALIZATION_FILE_PATH = Utils.SERIALIZATION_FILE_PATH + Utils.JSON_SERIALIZATION_FILE_NAME;

    @Test
    public void objectToXMLFileTest() throws IOException {
        File file = new File(XML_SERIALIZATION_FILE_PATH);
        OBJECT_MAPPER.serialize(person, file);

        PersonJson personFromXML = OBJECT_MAPPER.deserialize(file);
        Assert.assertNotSame(person, personFromXML);
        Assert.assertEquals(person, personFromXML);
    }
}
