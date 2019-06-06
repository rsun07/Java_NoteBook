package pers.xiaoming.notebook.rxjava.transforming;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.GroupedObservable;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import pers.xiaoming.notebook.rxjava.DemoBase;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Slf4j
@Ignore("don't run demo during maven build")
public class BasicTransformingDemo extends DemoBase {

    @Test
    public void mapDemo() {
        Observable.just(1, 2, 3)
                .map(integer -> integer * 2)
                .subscribe(createConsumer("map"));
    }

    @Test
    public void flatMapDemo() {
        // map is transforming the old element in the Observable stream into new element in the same Observable stream
        // flatMap is transforming each old element into a new Observable stream and them merge the elements in each new Observables into a new Observable
        // flatMap uses merge() to combine elements
        Observable.just(1, 2, 3)
                .flatMap(integer -> Observable.just(integer, Character.toChars(integer + 64), integer * 100, integer + 100))
                .subscribe(createConsumer("flatMap"));
    }

    @Test
    public void concatMapDemo() {
        // concatMap uses concat() to combin elements
        Observable.just(1, 2, 3)
                .concatMap(integer -> Observable.just(integer, Character.toChars(integer + 64), integer * 100, integer + 100))
                .subscribe(createConsumer("concatMap"));
    }

    @Test
    public void flatMapIterableDemo() {
        Observable.just(1, 2, 3)
                .flatMapIterable(integer -> Arrays.asList(Character.toChars(integer + 64), integer, integer * 100))
                .subscribe(createConsumer("flatMapIterable"));

    }

    @Test
    public void switchMapDemo() {
        Observable.just(1, 2, 3)
                .switchMap(integer -> Observable.just(integer, Character.toChars(integer + 64), integer * 100, integer + 100))
                .subscribe(createConsumer("switchMap"));
    }

    @Test
    public void castDemo() {
        Observable.just(1, 2 ,3)
                .cast(Number.class)
                .subscribe(createConsumer("cast"));

    }

    @Test
    public void scanDemo() {
        Observable.just(6, 7 ,8)
                .scan((last, current) -> {
                    log.info("last item is {}, current item is {}", last, current);
                    // It's only when the subscribe() is executed, the scan() will be executed
                    sleep(1000);
                    return last + current;
                })
                .subscribe(createConsumer("scan"));

    }

    @Test
    public void bufferDemo() {
        Observable.just(0, 1, 2 ,3, 4, 5, 6, 7, 8, 9)
                .buffer(3)
                .subscribe(createConsumer("buffer"));

    }

    @Test
    public void toListDemo() {
        Observable.just(0, 1, 2 ,3, 4, 5, 6, 7, 8, 9)
                // compare with the result of buffer()
                .toList(3) // here is capacityHint rather than the count in buffer()
                .subscribe(createConsumer("toList"));

        Observable.just(5, 8, 3, 1, 0, 7, 2, 6)
                .toSortedList()
                .subscribe(createConsumer("toSortedList"));

        Observable.just(5, 8, 3, 1, 0, 7, 2, 6)
                .toSortedList((int1, int2) -> {return int2-int1;})
                .subscribe(createConsumer("toSortedList with Customized comparator"));
    }

    @Test
    public void groupByDemo() {
        Observable.intervalRange(0, 10, 10, 10, TimeUnit.MILLISECONDS)
                .groupBy(integer -> "MyGroup " + (integer % 3))
                .subscribe(new Consumer<GroupedObservable<String, Long>>() {
                    @Override
                    public void accept(GroupedObservable<String, Long> groupedObservable) throws Exception {
                        groupedObservable.subscribe(new Consumer<Long>() {
                            @Override
                            public void accept(Long aLong) throws Exception {
                                String groupName = groupedObservable.getKey();
                                log.info("Number {} is assigned to {}", aLong, groupName);
                            }
                        });
                    }
                });

        sleep(100);

        log.info("separator\n\n");

        // convert consumer to lambda
        Observable.intervalRange(0, 10, 10, 10, TimeUnit.MILLISECONDS)
                .groupBy(integer -> "MyGroup " + (integer % 3))
                .subscribe(groupedObservable ->
                        groupedObservable.subscribe(aLong -> {
                            String groupName = groupedObservable.getKey();
                            log.info("Number {} is assigned to {}", aLong, groupName);
                        })
                );
        sleep(100);

    }
}
