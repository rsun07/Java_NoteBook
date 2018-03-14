package Java8.JavaDate;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

public class LocalDateAndTimeTest {

    @Test
    public void testLocalDateBasic() {
        LocalDate today = LocalDate.now();
        System.out.println(today);
    }

    @Test
    public void testLocalTimeBasic() {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
    }

    @Test
    public void testLocalDateTimeCreation() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        localDateTime = LocalDateTime.of(1990, 3, 28, 22, 58, 59);
        System.out.println(localDateTime);

        // cannot Initialize it because the constructor is private
        // localDateTime = new LocalDateTime();

        localDateTime = LocalDateTime.ofInstant(Instant.now(), ZoneId.of("UTC"));
        System.out.println(localDateTime);
    }

    /*
     *
     * LocalTime and LocalDateTime plus and minus are similar.
     * Read Java Doc for more similar functions
     *
     */
    @Test
    public void testLocalDateOperation() {
        LocalDate today = LocalDate.now();
        System.out.println(today);
        System.out.printf(
                "\nChronology is <%s>, Era is <%s>, Year is <%s>, \n" +
                "Month is <%s>, Month number is <%s>, \n" +
                "Day of Month is <%s>, Dat of week is <%s>. \n\n",
                today.getChronology(),
                today.getEra(),
                today.getYear(),
                today.getMonth(),
                today.getMonthValue(),
                today.getDayOfMonth(),
                today.getDayOfWeek());


        LocalDate tomorrow = today.plusDays(1);
        System.out.println(tomorrow);

        LocalDate lastYearToday = today.minusYears(1);
        System.out.println(lastYearToday);
    }

    @Test
    public void testLocalDateTimeImmutable() {
        LocalDateTime localDateTime = LocalDateTime.of(1990, 3, 28, 22, 58, 59);

    }
}
