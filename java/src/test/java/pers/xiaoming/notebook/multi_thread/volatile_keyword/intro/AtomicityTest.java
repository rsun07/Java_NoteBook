package pers.xiaoming.notebook.multi_thread.volatile_keyword.intro;

import org.junit.Test;

public class AtomicityTest {
    /*
        Every time it run, the result is different but less than 1000*1000
     */
    @Test
    public void failAtomicity() {
        FailAtomicity testClass = new FailAtomicity();

        for (int i = 0; i < 1000; i++) {
            new Thread(
                () -> {
                    for (int j = 0; j < 1000; j++) {
                        testClass.addRes();
                    }
                }
            ).start();
        }

        System.out.println(testClass.getRes());
    }
}
