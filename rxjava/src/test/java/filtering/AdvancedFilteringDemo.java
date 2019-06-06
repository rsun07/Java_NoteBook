package filtering;

import io.reactivex.Flowable;
import io.reactivex.functions.Action;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

@Slf4j
@Ignore("don't run demo during maven build")
public class AdvancedFilteringDemo extends FilteringDemoBase {

    @Test
    public void ofTypeDemo() {
        Flowable.just("1", 'E' , 2, 'a' ,3, 5L)
                .ofType(Character.class)
                .subscribe(createConsumer("of type chars"));
    }

    @Test
    public void skipDemo() {
        Flowable.just("1", 2, 3, 4, Arrays.asList(1, 2, 3), 'a')
                // skip means skip first #num of elements
                .skip(2)
                .skipLast(3)
                .subscribe(createConsumer("skip and skipLast"));
    }

    @Test
    public void ignoreElementsDemo() {
        Flowable.just("1", 2, 3, 4, Arrays.asList(1, 2, 3), 'a')
                // skip means skip first #num of elements
                .ignoreElements()
                // only trigger Action(), onComplete()
                // here I don't use lambda because it will hide the real class be implemented
                // It's Action() instead of Consumer()
                .subscribe(new Action() {
                    @Override
                    public void run() throws Exception {
                        log.info("on complete!");
                    }
                });
    }

    @Test
    public void dinstinctDemo() {
        Flowable.just(1, 1, 2, 3, 2, 2, 3, 5, 1)
                .distinct()
                // the order will be based on the first time it appear
                .subscribe(createConsumer("distinct"));

        Flowable.just(1, 1, 2, 3, 2, 2, 3, 5, 1)
                .distinctUntilChanged()
                // the order will be based on the first time it appear
                .subscribe(createConsumer("distinctUntilChanged"));
    }
}
