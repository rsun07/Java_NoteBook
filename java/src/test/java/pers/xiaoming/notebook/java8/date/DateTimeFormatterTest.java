package java8.date;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterTest {
    @Test
    public void testBuiltInFormatter() {
        LocalDateTime localDateTime = LocalDateTime.now();

        String strDate = localDateTime.format(DateTimeFormatter.ISO_DATE);
        System.out.println(strDate);
    }

    @Test
    public void testCustomizedFormatter() {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy -= HH:mm");
        LocalDateTime localDateTime = LocalDateTime.now();

        String strDateTime = localDateTime.format(formatter);
        System.out.println(strDateTime);
    }
}
