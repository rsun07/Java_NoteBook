package pers.xiaoming.notebook.java8.date;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 *
 * TemporalAdjuster is a functional Interface
 * TemporalAdjusters is a Collection of Common and useful TemporalAdjusters.
 */
public class TemporalAdjusterTest {

    @Test
    public void testTemporalAdjusters() {
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);

        LocalDateTime changeDay = time.withDayOfMonth(8);
        System.out.println(changeDay);

        LocalDateTime nextSunday = time.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(nextSunday);
    }

    @Test
    public void testCustomizedTemporalAdjuster() {
        TemporalAdjuster nextWorkdayTemporalAdjuster = new NextWorkdayTemporalAdjuster();
        LocalDate today = LocalDate.now();
        System.out.println("Next workday is: " +
                            nextWorkdayTemporalAdjuster.adjustInto(today));

        LocalDate nextWeekend = today.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println("Next workday is: " +
                nextWorkdayTemporalAdjuster.adjustInto(nextWeekend));
    }
}
