package pers.xiaoming.notebook.rxjava.combining;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableOnSubscribe;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import pers.xiaoming.notebook.rxjava.DemoBase;

import java.util.concurrent.TimeUnit;

@Slf4j
@Ignore("don't run demo during maven build")
public class CombiningDemo extends DemoBase {

    @Test
    public void startWithDemo() {
        Flowable.just(5, 6, 7)
                .startWith(3)
                .startWith(Flowable.just(1, 2))
                .startWithArray(-1, 0)
                .subscribe(createConsumer("startWith"));
    }

    @Test
    public void concatDemo() {
        // At most concat 4 observable
        // use concatArray() to concat more
        Flowable.concat(
                Flowable.just(1, 2, 3),
                Flowable.empty(),
                Flowable.just(5, 6, 7)
        ).subscribe(createConsumer("concat"));
    }

    @Test
    public void mergeDemo() {
        // concat() is executed in sequence
        // merge() is executed in timeline order
        Flowable.concat(
                Flowable.intervalRange(0, 3, 1, 1, TimeUnit.SECONDS),
                Flowable.intervalRange(5, 2, 1, 1, TimeUnit.SECONDS)
        ).subscribe(createConsumer("concat"));

        sleep(6000);
        log.info("\n\nseparator\n\n");

        Flowable.merge(
                Flowable.intervalRange(0, 3, 1, 1, TimeUnit.SECONDS),
                Flowable.intervalRange(5, 2, 1, 1, TimeUnit.SECONDS)
        ).subscribe(createConsumer("merge"));

        sleep(3000);
    }

    // concat is similar
    @Test
    public void mergeDelayErrorDemo() {
        FlowableOnSubscribe<Integer> source = s ->
                s.onError(new NullPointerException());

        Flowable.merge(
                Flowable.just(1, 2, 3),
                Flowable.create(source, BackpressureStrategy.ERROR),
                Flowable.just(5, 6, 7)
        ).subscribe(createConsumer("merge with error"));

        log.info("\n\nseparator\n\n");

        Flowable.mergeDelayError(
                Flowable.just(1, 2, 3),
                Flowable.create(source, BackpressureStrategy.ERROR),
                Flowable.just(5, 6, 7)
        ).subscribe(createConsumer("mergeDelayError with error"));
    }
}
