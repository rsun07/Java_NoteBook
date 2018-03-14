package Java8.JavaDate;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class ZoneDateAndTime {

    @Test
    public void printZoneIds() {
        Set<String> builtInZones = ZoneId.getAvailableZoneIds();
        builtInZones.forEach(System.out::println);
    }

    @Test
    public void testGetTimeByZoneId() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime monacoDateTime = LocalDateTime.now(ZoneId.of("Europe/Monaco"));
        System.out.println(localDateTime);
        System.out.println(monacoDateTime);
    }

    @Test
    public void testSetTimeToZoneId() {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Asia/Amman"));
        System.out.println(localDateTime);
        System.out.println(zonedDateTime);
    }
}
