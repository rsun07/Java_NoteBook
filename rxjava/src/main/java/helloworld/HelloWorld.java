package helloworld;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

public class HelloWorld {
    public static void main(String[] args) {
        hello("Ben", "Dav", "Jane");
        helloBeforeJava8Lambdas("Ben", "Dav", "Jane");
    }

    static void hello(String... args) {
        Flowable.fromArray(args).subscribe(s -> System.out.println("Hello " + s + "!"));
    }

    static void helloBeforeJava8Lambdas(String... args) {
        Flowable.fromArray(args).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("Hello " + s + "!");
            }
        });
    }
}
