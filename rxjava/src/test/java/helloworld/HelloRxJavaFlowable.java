package helloworld;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableSubscriber;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Slf4j
public class HelloRxJavaFlowable {

    @Test
    public void flowableDemo() {
        StringBuilder sb = new StringBuilder();

        FlowableSubscriber<String> subscriber = new FlowableSubscriber<String>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                subscription.request(10L);
            }

            @Override
            public void onNext(String s) {
                sb.append(s);
                log.info("append {}, new the sb is {}", s, sb.toString());
            }

            @Override
            public void onError(Throwable t) {
                log.error(t.getLocalizedMessage());
            }

            @Override
            public void onComplete() {
                log.info("subscriber completed!");
            }
        };

        Flowable<String> flowable = Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> flowableEmitter) throws Exception {
                flowableEmitter.onNext("a");
                flowableEmitter.onNext("b");
                flowableEmitter.onComplete();
                log.info("Result string is: {}" ,sb.toString());
            }
        }, BackpressureStrategy.BUFFER);

        flowable.subscribe(subscriber);
    }
}
