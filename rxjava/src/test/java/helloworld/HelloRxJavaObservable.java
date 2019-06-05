package helloworld;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;


@Slf4j
public class HelloRxJavaObservable {

    @Test
    public void ObservableDemo() {
        StringBuilder sb = new StringBuilder();

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                log.info("Instance of <{}> subscribes us", disposable.getClass());
            }

            @Override
            public void onNext(String s) {
                sb.append(s);
                log.info("append {}, new the sb is {}", s, sb.toString());
            }

            @Override
            public void onError(Throwable throwable) {
                log.error(throwable.getLocalizedMessage());
            }

            @Override
            public void onComplete() {
                log.info("subscriber completed!");
            }
        };

        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                observableEmitter.onNext("a");
                observableEmitter.onNext("b");
                observableEmitter.onComplete();
                log.info("Result string is: {}", sb.toString());
            }
        }); // No back pressure strategy config comparing to Flowable

        observable.subscribe(observer);
    }
}
