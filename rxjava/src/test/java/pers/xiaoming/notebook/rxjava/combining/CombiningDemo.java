package pers.xiaoming.notebook.rxjava.combining;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.functions.BiConsumer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import pers.xiaoming.notebook.rxjava.DemoBase;

import java.util.ArrayList;
import java.util.concurrent.Callable;
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

    @Test
    public void zipDemo() {
        // output a new Flowable with 0*5 and 1*6.
        // 2 and 3 in first stream are ignored
        Flowable.zip(
            Flowable.just(0, 1, 2, 3),
            Flowable.just(5, 6),
            (int1, int2) -> int1 * int2
        ).subscribe(createConsumer("zip"));
    }

    @Test
    public void reduceDemo() {
        Flowable.just(9, 8, 7)
                .reduce((result, x) -> {
                    log.info("reduce item {} with pre-result {}", x, result);
                    return result + x;
                })
                .subscribe(createConsumer("reduce"));
    }

    @Test
    public void countDemo() {
        Flowable.just(7, 8, 9)
                .count()
                .subscribe(createConsumer("count"));
    }

    @Test
    public void collect() {
        // for better understand, first version is traditional Java implementation
        Flowable.just(1, 2, 3)
                .collect(
                        new Callable<ArrayList<Integer>>() {
                            @Override
                            public ArrayList<Integer> call() throws Exception {
                                return new ArrayList<>();
                            }
                        },
                        new BiConsumer<ArrayList<Integer>, Integer>() {
                            @Override
                            public void accept(ArrayList<Integer> list, Integer integer) throws Exception {
                                list.add(integer);
                            }
                        }
                ).subscribe(createConsumer("collect"));

        // pure lambda version, short
        Flowable.just(1, 2, 3)
                .collect(ArrayList::new, ArrayList::add)
                .subscribe(createConsumer("collect (lambda impl)"));

    }
}
