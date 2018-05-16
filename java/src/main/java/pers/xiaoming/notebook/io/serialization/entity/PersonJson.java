package pers.xiaoming.notebook.io.serialization.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonJson {
    @JsonProperty
    private String name;

    @JsonProperty
    private int age;

    @JsonProperty
    private int salary;

    @JsonProperty(value = "phone_number")
    private String phoneNum;
}
