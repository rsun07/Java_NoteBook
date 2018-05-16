package pers.xiaoming.notebook.io.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class PersonObjectMapper<T> {
    private final ObjectMapper OBJECT_MAPPER;
    private final Class<T> personClass;

    public PersonObjectMapper(ObjectMapper OBJECT_MAPPER, Class<T> personClass) {
        this.OBJECT_MAPPER = OBJECT_MAPPER;
        this.personClass = personClass;
    }

    public String serialize(T person) throws JsonProcessingException {
        String xmlString = OBJECT_MAPPER.writeValueAsString(person);
        return xmlString;
    }

    public boolean serialize(T person, File file) throws IOException {
        OBJECT_MAPPER.writeValue(file, person);
        return true;
    }

    public T deserialize(String xmlString) throws IOException {
        T person = OBJECT_MAPPER.readValue(xmlString, personClass);
        return person;
    }

    public T deserialize(File file) throws IOException {
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
