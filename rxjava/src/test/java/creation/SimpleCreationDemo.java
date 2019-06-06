package creation;

import io.reactivex.Flowable;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;

@Slf4j
@Ignore("don't run demo during maven build")
public class SimpleCreationDemo {

    @Test
    public void justDemo() {
        Flowable.just("1", "2")
                .subscribe(/* here means an onNext() Consumer lambda impl*/str -> log.info("just {}", str));
    }

    @Test
    public void fromArrayDemo() {
        Flowable.fromArray(1, 2, 3)
                .subscribe(integer -> log.info("just {}", integer));
    }

    // only onComplete() will be execute
    @Test
    public void emptyDemo() {
        Flowable.empty().subscribe(
                obj -> log.info("On next run, {}", obj.getClass()),
                e -> log.error("Error happens, {}", e.getMessage()),
                () -> log.info("subscriber completed!")
        );
    }

    // [main] ERROR creation.SimpleCreationDemo - Error happens, Runtime Exception triggered!
    @Test
    public void errorDemo() {
        Flowable.error(new RuntimeException("Runtime Exception triggered!")).subscribe(
                obj -> log.info("On next run, {}", obj.getClass()),
                e -> log.error("Error happens, {}", e.getMessage()),
                () -> log.info("subscriber completed!")
        );
    }

    // none of the three get printed
    @Test
    public void neverDemo() {
        Flowable.never().subscribe(
                obj -> log.info("On next run, {}", obj.getClass()),
                e -> log.error("Error happens, {}", e.getMessage()),
                () -> log.info("subscriber completed!")
        );
    }
}
