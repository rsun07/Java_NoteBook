package creation;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.model.TestTimedOutException;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Slf4j
@Ignore("don't run demo during maven build")
public class AdvancedCreationDemo {

    private CountDownLatch countDownLatch = new CountDownLatch(2);

    private Consumer<Long> consumer = new Consumer<Long>() {
        @Override
        public void accept(Long aLong) throws Exception {
            log.info("{} milliseconds passed", aLong);
        }
    };

    private void demoSubscribe(Flowable<Long> flowable) {
        flowable.subscribe(consumer);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fromIterableDemo() {
        List<Long> list = Arrays.asList(1000L, 2000L, 3000L);

        demoSubscribe(Flowable.fromIterable(list));
    }

    @Test
    public void fromTimerBuilder() {
        demoSubscribe(Flowable.timer(1, TimeUnit.MILLISECONDS));
    }

    @Test(timeout = 300L, expected = TestTimedOutException.class)
    public void fromIntervalBuilder() throws InterruptedException {
        // this never stop
        demoSubscribe(Flowable.interval(2, 1, TimeUnit.MILLISECONDS));
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
