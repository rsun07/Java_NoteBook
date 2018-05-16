package pers.xiaoming.notebook.io.serialization;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Assert;
import org.junit.Test;
import pers.xiaoming.notebook.io.Utils;
import pers.xiaoming.notebook.io.serialization.entity.PersonXML;

import java.io.File;
import java.io.IOException;

public class JacksonXMLTest {
    private final static PersonObjectMapper<PersonXML> XML_MAPPER = new PersonObjectMapper<>(new XmlMapper(), PersonXML.class);
    private PersonXML person = new PersonXML("myName", 23, 5000, "310-000-0000");

    // <PersonXML name="myName" age="23" xmlns:wstxns1="phone_number" wstxns1:phoneNum="310-000-0000"><salary>5000</salary></PersonXML>
    @Test
    public void objectToXMLStringTest() throws IOException {
        String xmlString = XML_MAPPER.serialize(person);
        System.out.println(xmlString);

        PersonXML personFromXML = XML_MAPPER.deserialize(xmlString);
        Assert.assertNotSame(person, personFromXML);
        Assert.assertEquals(person, personFromXML);
    }

    private final static String XML_SERIALIZATION_FILE_PATH = Utils.SERIALIZATION_FILE_PATH + Utils.XML_SERIALIZATION_FILE_NAME;
    @Test
    public void objectToXMLFileTest() throws IOException {
        File file = new File(XML_SERIALIZATION_FILE_PATH);
        XML_MAPPER.serialize(person, file);

        PersonXML personFromXML = XML_MAPPER.deserialize(file);
        Assert.assertNotSame(person, personFromXML);
        Assert.assertEquals(person, personFromXML);
    }
}
