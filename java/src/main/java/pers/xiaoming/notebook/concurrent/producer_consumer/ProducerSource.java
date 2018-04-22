package pers.xiaoming.notebook.concurrent.producer_consumer;

import java.util.Random;

public class ProducerSource {
    static int produceInt() {
        Random random = new Random();

        return random.nextInt(100);
    }
}
