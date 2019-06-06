package pers.xiaoming.notebook.rxjava.creation;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.model.TestTimedOutException;
import pers.xiaoming.notebook.rxjava.DemoBase;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Ignore("don't run demo during maven build")
public class AdvancedCreationDemo extends DemoBase {

    @Test
    public void fromIterableDemo() {
        List<Long> list = Arrays.asList(1000L, 2000L, 3000L);

        Flowable.fromIterable(list)
                .subscribe(createConsumer("from iterable"));
    }

    @Test
    public void fromTimerBuilder() {
        Flowable.timer(1, TimeUnit.MILLISECONDS)
                .subscribe(createConsumer("from timer"));

        sleep(1000);
    }

    @Test(timeout = 300L, expected = TestTimedOutException.class)
    public void fromIntervalBuilder() throws InterruptedException {
        // this never stop
        Flowable.interval(2, 1, TimeUnit.MILLISECONDS)
                .subscribe(createConsumer("from interval"));

        sleep(5000);
    }

    @Test
    public void deferDemo() {
        Consumer<Integer> consumer = integer -> {
            Thread.sleep(1000);
            log.info("integer, {}", ++integer);
        };

        Flowable<Integer> flowable = Flowable.defer(() -> Flowable.just(1));
        flowable.subscribe(consumer);
        flowable.subscribe(consumer);
    }
}
