package RealTimePractice;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStampToLong {

    public static void main(String[] args) {
        TimeStampToLong timeStampToLong = new TimeStampToLong();
        try {
            timeStampToLong.parse();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void parse() throws ParseException {
        String dateStr = "Mon Jun 18 00:00:00 IST 2012";
        String dateStr2 = "Tue Apr 17 23:58:59 UTC 2012";
        DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        Date date = (Date) formatter.parse(dateStr2);
        System.out.println(date.getTime());

        Timestamp timestamp = new Timestamp(date.getTime());
        System.out.println(timestamp);
        System.out.println(timestamp.getTime());




//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        StringTest formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
//        System.out.println("formatedDate : " + formatedDate);
    }
}
