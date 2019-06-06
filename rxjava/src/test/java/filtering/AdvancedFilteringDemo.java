package filtering;

import io.reactivex.Flowable;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;

@Slf4j
@Ignore("don't run demo during maven build")
public class AdvancedFilteringDemo extends FilteringDemoBase {

    @Test
    @SuppressWarnings("unchecked")
    public void ofTypeDemo() {
        Flowable.just("1", 'E' , 2, 'a' ,3, 5L)
                .ofType(Character.class)
                .subscribe(createConsumer("of type chars"));
    }
}
