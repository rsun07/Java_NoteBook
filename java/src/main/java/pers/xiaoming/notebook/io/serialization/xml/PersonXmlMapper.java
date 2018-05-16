package pers.xiaoming.notebook.io.serialization.xml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import pers.xiaoming.notebook.io.serialization.entity.PersonXML;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class PersonXmlMapper {
    private static final XmlMapper XML_MAPPER = new XmlMapper();

    public static String serialize(PersonXML person) throws JsonProcessingException {
        String xmlString = XML_MAPPER.writeValueAsString(person);
        return xmlString;
    }

    public static boolean serialize(PersonXML person, File file) throws IOException {
        XML_MAPPER.writeValue(file, person);
        return true;
    }

    public static PersonXML deserialize(String xmlString) throws IOException {
        PersonXML person = XML_MAPPER.readValue(xmlString, PersonXML.class);
        return person;
    }

    public static PersonXML deserialize(File file) throws IOException {
        String xmlString = inputStreamToString(new FileInputStream(file));
        return deserialize(xmlString);
    }

    private static String inputStreamToString(FileInputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        while ((line=br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
}
