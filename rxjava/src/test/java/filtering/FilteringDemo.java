package filtering;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;

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

    private <T> Consumer<T> createConsumer(String msg) {
        return new Consumer<T>() {
            @Override
            public void accept(T t) throws Exception {
                log.info("{}, {}", msg, t);
            }
        };
    }

    private void sleep(long sleeptimeInMillis) {
        try {
            Thread.sleep(sleeptimeInMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void takeDemo() {
        int numberTake = 5;

        Flowable.interval(1, TimeUnit.SECONDS)
                // returns a new Flowable<T>
                .take(numberTake)
                .subscribe(createConsumer("take " + numberTake + " from interval"));

        sleep(6000);
    }

    @Test
    public void takeLastDemo() {

        Flowable.just(1, 2, 3, 4, 5)
                // returns a new Flowable<T>
                .takeLast(3)
                .subscribe(createConsumer("takeLast 3 from just"));

        sleep(100);


        Flowable.intervalRange(0, 10, 200, 200, TimeUnit.MILLISECONDS)
                .takeLast(3)
                .subscribe(createConsumer("takeLast 3 from interval range"));

        sleep(2000);
    }

    @Test
    public void firstAndLastElementDemo() {
        Flowable.just(1, 2, 3)
                // returns a new Maybe<T> instead of Flowable<T>
                .firstElement()
                .subscribe(createConsumer("firstElement"));

        sleep(100);


        Flowable.just(1, 2, 3)
                .lastElement()
                .subscribe(createConsumer("lastElement"));

        sleep(100);


        Flowable.empty()
                .firstElement()
                .subscribe(createConsumer("firstElement from empty"));

        sleep(100);
    }

    @Test
    public void firstAndLastDemo() {
        Flowable.just(1, 2, 3)
                // returns a new Single<T> instead of Flowable<T>
                // here means the default value rather than first two
                .first(20)
                .subscribe(createConsumer("first"));

        sleep(100);


        Flowable.empty()
                // here means the default value
                .first(20)
                .subscribe(createConsumer("first from empty"));

        sleep(100);


        Flowable.just(1, 2, 3)
                // returns a new Single<T> instead of Flowable<T>
                // here means the default value
                .last(20)
                .subscribe(createConsumer("last"));

        sleep(100);


        Flowable.empty()
                // here means the default value
                .last(20)
                .subscribe(createConsumer("last from empty"));

        sleep(100);
    }
}
