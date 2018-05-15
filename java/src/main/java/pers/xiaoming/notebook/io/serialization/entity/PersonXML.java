package pers.xiaoming.notebook.io.serialization.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonXML {
    @JacksonXmlProperty(isAttribute = true)
    private String name;

    @JacksonXmlProperty(isAttribute = true)
    private int age;

    @JacksonXmlProperty(isAttribute = false)
    private transient int salary;

    @JacksonXmlProperty(namespace = "phone_number", isAttribute = true)
    private transient int phoneNum;
}
