package test;


import org.apache.commons.lang.RandomStringUtils;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    private static final String ALPHABET = "ACDEFGHJKMNPRSTUVWXYZ2345679";

    public static void main(test.StringTest[] args) throws IOException, ParseException {
        Test test = new Test();
        for (int i = 0; i < 9999; i++)
            System.out.println(test.print());

        List<String> list = new ArrayList<>();
        list.iterator();
        String[] strs = new String[10];
        strs = list.toArray(strs);
    }

    public Test() {
    }

    public String print() {
        return RandomStringUtils.random(7, ALPHABET);
    }


}

