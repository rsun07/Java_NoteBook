package pers.xiaoming.notebook.rxjava.transforming;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.GroupedObservable;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import pers.xiaoming.notebook.rxjava.DemoBase;

import java.util.concurrent.TimeUnit;

@Slf4j
@Ignore("don't run demo during maven build")
public class AdvancedTransformingDemo extends DemoBase {
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

    @Test
    public void toMapDemo() {
        // convert consumer to lambda
        Observable.intervalRange(0, 10, 10, 10, TimeUnit.MILLISECONDS)
                .toMap(integer -> "Key " + (integer % 3))
                .subscribe(createConsumer("toMap"));
        sleep(100);

        Observable.intervalRange(0, 10, 10, 10, TimeUnit.MILLISECONDS)
                .toMap(
                        // key selector
                        integer -> "Key " + (integer % 3),
                        // value selector
                        integer -> integer*100)
                .subscribe(createConsumer("toMap with value selector"));
        sleep(100);
    }
}
