package pers.xiaoming.notebook.concurrent.producer_consumer_problem.producer;

import java.util.Random;

public class ProducerDataSource {
    static int produceInt() {
        Random random = new Random();

        return random.nextInt(100);
    }
}
