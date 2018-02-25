package JavaTest.RealTimePractice.JavaTimeZone;


import org.junit.Test;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeZoneJava8 {
    private final String dataTimeFormatPattern = "yyyy-MM-dd HH:mm:ss";

    @Test
    public void testDateTimeFormatter() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dataTimeFormatPattern);

        String time = ZonedDateTime.now(ZoneId.of("GMT")).format(formatter);
        System.out.println(time);
        System.out.println(ZonedDateTime.now(ZoneId.of("GMT")));
        System.out.println(ZonedDateTime.now(ZoneId.of("GMT")).plus(Duration.ofSeconds(86400)));
    }
}
