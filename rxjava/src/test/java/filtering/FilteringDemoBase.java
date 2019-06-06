package filtering;

import io.reactivex.functions.Consumer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class FilteringDemoBase {
    <T> Consumer<T> createConsumer(String msg) {
        return new Consumer<T>() {
            @Override
            public void accept(T t) throws Exception {
                log.info("{}, {}", msg, t);
            }
        };
    }

    void sleep(long sleeptimeInMillis) {
        try {
            Thread.sleep(sleeptimeInMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
