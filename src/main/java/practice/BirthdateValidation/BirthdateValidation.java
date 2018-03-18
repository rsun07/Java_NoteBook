package practice.BirthdateValidation;


import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class BirthdateValidation {

    public static void main(String[] args) throws IOException, ParseException {
        BirthdateValidation bv = new BirthdateValidation();

        String date1 = "1970-12-12";
        String date2 = "1900-13-12";
        String date3 = "1970-12-42";
        String date4 = "2003-09-30";
        String date5 = "2016-09-12";
        String date6 = "1888-12-12";
        String date7 = "1888-12-12";

//
//        System.out.println("1: " + bv.checkBirthdate(date1));
//        System.out.println("2: " + bv.checkBirthdate(date2));
//        System.out.println("3: " + bv.checkBirthdate(date3));
        System.out.println("4: " + bv.checkBirthdate(date4));
//        System.out.println("5: " + bv.checkBirthdate(date5));
//        System.out.println("6: " + bv.checkBirthdate(date6));
//        System.out.println("7: " + bv.checkBirthdate(date7));


    }

    private boolean checkBirthdate(String birthdate) throws DateTimeParseException {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(birthdate, formatter);
            LocalDate currentTime = LocalDate.now();

            LocalDate now = LocalDate.now();
//            Period period = Period.between(date, now);
//
//            System.out.println(period.getYears());
//            if (period.getYears() < 13) {
//                throw new RuntimeException("non-kids user profile cannot be under 13 years old");
//            }


            if (!now.minusYears(13).isBefore(date)) {
                throw new RuntimeException("non-kids user profile cannot be under 13 years old");
            }



            if (date.getYear() < 1900) {
                throw new RuntimeException("birth year cannot be earlier than 1900");
            }
            return true;
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            throw new RuntimeException("invalid birthdate format");
        }
    }
}
