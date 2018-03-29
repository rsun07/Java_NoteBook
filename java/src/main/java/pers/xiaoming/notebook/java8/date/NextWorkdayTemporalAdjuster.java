package pers.xiaoming.notebook.java8.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class NextWorkdayTemporalAdjuster implements TemporalAdjuster {
        @Override
        public Temporal adjustInto(Temporal temporal) {
            LocalDate today = (LocalDate) temporal;
            DayOfWeek dayOfWeek = today.getDayOfWeek();

            if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
                return today.plusDays(3);
            } else if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
                return today.plusDays(2);
            } else {
                return today.plusDays(1);
            }
        }
}
