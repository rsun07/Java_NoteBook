package JavaTest.RealTimePractice.JavaTimeZone;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Timezone {
    @Test
    public void testCalendar() {
        System.out.println("Current system million seconds : " +System.currentTimeMillis());

        Calendar calendar = Calendar.getInstance();
        System.out.println("Current calendar time in millis : " + calendar.getTimeInMillis());

        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        System.out.println("Current calendar time in millis after set time zone to UTC : "
            + calendar.getTimeInMillis());
    }

    @Test
    public void testSimepleFormat() {
        SimpleDateFormat dateFormatGmt = new SimpleDateFormat();
        dateFormatGmt.setTimeZone(TimeZone.getTimeZone("GMT"));

        System.out.println(dateFormatGmt.getCalendar().getTimeInMillis());
        System.out.println(dateFormatGmt.format(new Date()));

        dateFormatGmt.format(new Date());
        System.out.println(dateFormatGmt.format(new Date(System.currentTimeMillis())));
    }

    @Test
    public void timeZoneConvert() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
        calendar.setTime(date);

        System.out.println("Current system million seconds : " +System.currentTimeMillis());
        System.out.println(calendar.getTimeInMillis());

    }
}
