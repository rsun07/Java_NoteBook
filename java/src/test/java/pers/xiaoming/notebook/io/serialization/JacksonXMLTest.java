package pers.xiaoming.notebook.io.serialization;

import org.junit.Assert;
import org.junit.Test;
import pers.xiaoming.notebook.io.Utils;
import pers.xiaoming.notebook.io.serialization.entity.PersonXML;
import pers.xiaoming.notebook.io.serialization.xml.PersonXmlMapper;

import java.io.File;
import java.io.IOException;

public class JacksonXMLTest {
    private PersonXML person = new PersonXML("myName", 23, 5000, "310-000-0000");

    // <PersonXML name="myName" age="23" xmlns:wstxns1="phone_number" wstxns1:phoneNum="310-000-0000"><salary>5000</salary></PersonXML>
    @Test
    public void objectToXMLStringTest() throws IOException {
        String xmlString = PersonXmlMapper.serialize(person);
        System.out.println(xmlString);

        PersonXML personFromXML = PersonXmlMapper.deserialize(xmlString);
        Assert.assertNotSame(person, personFromXML);
        Assert.assertEquals(person, personFromXML);
    }

    private final static String XML_SERIALIZATION_FILE_PATH = Utils.SERIALIZATION_FILE_PATH + Utils.XML_SERIALIZATION_FILE_NAME;
    @Test
    public void objectToXMLFileTest() throws IOException {
        PersonXML person = new PersonXML("myName", 23, 5000, "310-000-0000");
        File file = new File(XML_SERIALIZATION_FILE_PATH);
        PersonXmlMapper.serialize(person, file);

        PersonXML personFromXML = PersonXmlMapper.deserialize(file);
        Assert.assertNotSame(person, personFromXML);
        Assert.assertEquals(person, personFromXML);
    }
}
