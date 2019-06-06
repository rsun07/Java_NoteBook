package pers.xiaoming.notebook.rxjava.filtering;

import io.reactivex.Flowable;
import io.reactivex.functions.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import pers.xiaoming.notebook.rxjava.DemoBase;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

@Slf4j
@Ignore("don't run demo during maven build")
public class BasicFilteringDemo extends DemoBase {

    @Test
    public void BasicFilterDemo() {
        Flowable.just(0, 1, 2, 3)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer % 2 == 0;
                    }
                })
        .subscribe(integer -> log.info("Even number in stream: {}", integer));
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

        Flowable.just(1, 2, 3)
                .lastElement()
                .subscribe(createConsumer("lastElement"));

        Flowable.empty()
                .firstElement()
                .subscribe(createConsumer("firstElement from empty"));
    }

    @Test
    public void firstAndLastDemo() {
        Flowable.just(1, 2, 3)
                // returns a new Single<T> instead of Flowable<T>
                // here means the default value rather than first two
                .first(20)
                .subscribe(createConsumer("first"));

        Flowable.empty()
                // here means the default value
                .first(20)
                .subscribe(createConsumer("first from empty"));

        Flowable.just(1, 2, 3)
                // returns a new Single<T> instead of Flowable<T>
                // here means the default value
                .last(20)
                .subscribe(createConsumer("last"));

        Flowable.empty()
                // here means the default value
                .last(20)
                .subscribe(createConsumer("last from empty"));
    }

    @Test
    public void firstOrErrorDemo() {
        Flowable.just(1, 2, 3)
                // return a new Single<T> of first element, if no then throw error
                .firstOrError()
                .subscribe(createConsumer("firstOrError"));

        log.info("line separator \n\n");

        Flowable.empty()
                .firstOrError()
                .subscribe(
                    // onSuccess()
                    createConsumer("firstOrError from empty"),
                    // onError()
                    e -> {
                        log.error(e.getMessage());
                        throw (Exception) e;
                    }
                );

        sleep(100);
    }

    @Test
    public void elementAtDemo() {
        Flowable.just(1 ,2, 3)
                .elementAt(2)
                .subscribe(createConsumer("elementAt"));

        log.info("line separator \n\n");

        Flowable.just(1, 2, 3)
                .elementAt(20)
                .subscribe(createConsumer("elementAt out of bound"));

        log.info("line separator \n\n");

        Flowable.just(1, 2, 3)
                .elementAtOrError(20)
                .subscribe(createConsumer("elementAt out of bound"),
                        e -> {
                            log.error(e.getMessage());
                            throw (Exception) e;
                        });
    }

}
