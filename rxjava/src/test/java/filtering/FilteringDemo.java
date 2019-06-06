package filtering;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Slf4j
@Ignore("don't run demo during maven build")
public class FilteringDemo {

    @Test
    public void filterDemo() {
        Flowable.just(0, 1, 2, 3)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer % 2 == 0;
                    }
                })
        .subscribe(integer -> log.info("Even number in stream: {}", integer));
    }

    private void demoSubscribe(Flowable<Long> flowable, String msg, long sleepTimeInSecond) {
        Consumer<Long> consumer = new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                log.info("{}, {}", msg, aLong);
            }
        };

        flowable.subscribe(consumer);
        try {
            Thread.sleep(sleepTimeInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void takeDemo() {
        demoSubscribe(Flowable.interval(1, TimeUnit.SECONDS).take(5),
                "Take 5 from interval", 1);
    }

    @Test
    public void takeLastDemo() {
        demoSubscribe(Flowable.just(1L, 2L, 3L, 4L, 5L).takeLast(3),
                "takeLast 3 from just", 1);


        demoSubscribe(Flowable.intervalRange(0, 10, 200, 200, TimeUnit.MILLISECONDS).takeLast(3),
                "takeLast 3 from interval range", 2);
    }
}
