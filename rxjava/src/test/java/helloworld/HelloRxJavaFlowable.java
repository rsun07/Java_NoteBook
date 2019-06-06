package helloworld;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import org.reactivestreams.Subscription;

@Slf4j
@Ignore("don't run demo during maven build")
public class HelloRxJavaFlowable {

    @Test
    public void flowableDemo() {
        StringBuilder sb = new StringBuilder();

        FlowableSubscriber<String> subscriber = new FlowableSubscriber<String>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                log.info("Instance of <{}> subscribes us", subscription.getClass());
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
                log.info("Result string is: {}", sb.toString());
            }
        }, BackpressureStrategy.BUFFER);

        // Link them together
        flowable.subscribe(subscriber);
    }

    // If only use onNext(), could use Consumer to replace the completed implementation of FlowableSubscriber
    @Test
    public void simplifiedFlowableDemo() {
        StringBuilder sb = new StringBuilder();

        Flowable<String> flowable = Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> flowableEmitter) throws Exception {
                flowableEmitter.onNext("a");
                flowableEmitter.onNext("b");
                flowableEmitter.onComplete();
                log.info("Result string is: {}", sb.toString());
            }
        }, BackpressureStrategy.BUFFER);

        flowable.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                sb.append(s);
                log.info("append {}, new the sb is {}", s, sb.toString());
            }
        });
    }

    @Test
    public void ConsumerDemo() {
        StringBuilder sb = new StringBuilder();

        Flowable<String> flowable = Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> flowableEmitter) throws Exception {
                flowableEmitter.onNext("a");
                flowableEmitter.onNext("b");
                flowableEmitter.onComplete();
                log.info("Result string is: {}", sb.toString());
            }
        }, BackpressureStrategy.BUFFER);

        flowable.subscribe(
                // equivalent to onNext()
                new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        sb.append(s);
                        log.info("append {}, new the sb is {}", s, sb.toString());
                    }
                },

                // equivalent to onError()
                new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        log.error(throwable.getLocalizedMessage());
                    }
                },

                // equivalent to onComplete()
                new Action() {
                    @Override
                    public void run() throws Exception {
                        log.info("subscriber completed!");
                    }
                },

                // equivalent to onSubscribe()
                new Consumer<Subscription>() {
                    @Override
                    public void accept(Subscription subscription) throws Exception {
                        log.info("Instance of <{}> subscribes us", subscription.getClass());
                        subscription.request(10L);
                    }
                }
        );
    }
}
