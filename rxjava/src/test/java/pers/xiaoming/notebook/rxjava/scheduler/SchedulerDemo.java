package pers.xiaoming.notebook.rxjava.scheduler;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import pers.xiaoming.notebook.rxjava.DemoBase;

@Slf4j
public class SchedulerDemo extends DemoBase {

    @Test
    public void schedulerDemo() {
        Observable.just(1, 2, 3, 4, 5, 6)
                .map(integer -> {
                    log.info("first map");
                    return integer*2;
                })
                .map(integer -> {
                    log.info("second map");
                    return integer/2;
                })
                .subscribe(createConsumer("scheduler"));
    }

    @Test
    public void schedulerObserveOnDemo() {
        Observable.just(1, 2, 3, 4, 5, 6)
                .map(integer -> {
                    log.info("first map");
                    return integer*2;
                })
                .map(integer -> {
                    log.info("second map");
                    return integer/2;
                })
                .observeOn(Schedulers.single())
                .subscribe(createConsumer("scheduler observe On"));
        sleep(100);
    }

    @Test
    public void schedulerObserveOnDemo2() {
        Observable.just(1, 2, 3, 4, 5, 6)
                .map(integer -> {
                    log.info("first map");
                    return integer*2;
                })
                .map(integer -> {
                    log.info("second map");
                    return integer/2;
                })
                .observeOn(Schedulers.computation(), true)
                .subscribe(createConsumer("scheduler observe On"));
        sleep(100);
    }
}
