package java8.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Before Java 8, SimpleDateFormat is not thread safe.
public class DateFormatTest {

    @Test
    public void testSimpleDateFormat() {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Callable<Date> task = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                return dateFormat.parse("2018-01-01");
            }
        };

        runIt(task);
    }

    @Test
    public void testThreadLocal() {
        Callable<Date> task = () -> DateFormatThreadLocal.convert("2018-01-01");

        runIt(task);
    }


    /**
     *
     * DateTimeFormatter is the new Class in Java 8
     */
    @Test
    public void testDateTimeFormatter() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Callable<LocalDate> task = () -> LocalDate.parse("2018-01-01", dateTimeFormatter);

        runIt(task);

    }

    private void runIt(Callable<?> task) {
        ExecutorService threadpool = Executors.newFixedThreadPool(10);

        List<Future<?>> results = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            results.add(threadpool.submit(task));
        }

        for (Future<?> future : results) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        threadpool.shutdown();
    }
}
