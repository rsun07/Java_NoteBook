package pers.xiaoming.notebook.java8.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateFormatThreadLocal {

    private static final ThreadLocal<DateFormat> DATE_FORMAT = new ThreadLocal<DateFormat>(){
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public static Date convert(String dateStr) throws ParseException {
        return DATE_FORMAT.get().parse(dateStr);
    }
}
