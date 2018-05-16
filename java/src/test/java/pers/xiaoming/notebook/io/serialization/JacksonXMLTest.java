package pers.xiaoming.notebook.io.serialization;

import org.junit.Assert;
import org.junit.Test;
import pers.xiaoming.notebook.io.serialization.entity.PersonXML;
import pers.xiaoming.notebook.io.serialization.xml.PersonXmlMapper;

import java.io.IOException;

public class JacksonXMLTest {
    // <PersonXML name="myName" age="23" xmlns:wstxns1="phone_number" wstxns1:phoneNum="310-000-0000"><salary>5000</salary></PersonXML>
    @Test
    public void objectToXMLStringTest() throws IOException {
        PersonXML person = new PersonXML("myName", 23, 5000, "310-000-0000");
        String xmlString = PersonXmlMapper.serialize(person);
        System.out.println(xmlString);

        PersonXML personFromXML = PersonXmlMapper.deserialize(xmlString);
        Assert.assertNotSame(person, personFromXML);
        Assert.assertEquals(person, personFromXML);
    }
}
