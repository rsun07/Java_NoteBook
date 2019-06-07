package pers.xiaoming.notebook.rxjava.condition;

import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import pers.xiaoming.notebook.rxjava.DemoBase;

import java.util.concurrent.TimeUnit;


@Slf4j
@Ignore("don't run demo during maven build")
public class ConditionDemo extends DemoBase {
    @Test
    public void allDemo() {
        Observable.just(1, 2, 3)
                .all(integer -> integer % 2 == 0)
                .subscribe(createConsumer("all even number?"));

        Observable.just(1, 2, 3)
                .all(integer -> integer > 0)
                .subscribe(createConsumer("all positive?"));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void ambArrayDemo() {
        Observable.ambArray(
                Observable.timer(100, TimeUnit.MILLISECONDS),
                Observable.intervalRange(10, 5, 20, 10, TimeUnit.MILLISECONDS),
                Observable.just(3, 4, 5)
        ).subscribe(createConsumer("ambArray"));

        // the one who sent out the first element will be subscribed,
        // despite the second, third and following
        Observable.ambArray(
                Observable.intervalRange(0, 5, 100, 5, TimeUnit.MILLISECONDS),
                Observable.intervalRange(10, 5, 90, 20, TimeUnit.MILLISECONDS)
        ).subscribe(createConsumer("ambArray2"));

        sleep(500);
    }

    @Test
    public void containsDemo() {
        Observable.just(3, 6, 8)
                // only object, cannot be a condition check like
                // integer -> integer % 2 == 0
                // use any for Predicate input
                .contains(3)
                .subscribe(createConsumer("contains"));
    }

    @Test
    public void anyDemo() {
        Observable.just(3, 6, 8)
                // only object, cannot be a condition check like
                // integer -> integer % 2 == 0
                .any(integer -> integer % 2 == 0)
                .subscribe(createConsumer("any"));
    }
}
