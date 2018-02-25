package JavaTest.JavaBasicTest.MultiThread.TraditionalTread;

public class LockOnThread {
    // The object that used as a key should be the same object
    public static void main(String[] args) {
//        new LockOnThread().withoutLock();
//        new LockOnThread().failToLock1();
//        new LockOnThread().failToLock2();
        new LockOnThread().lock1();


    }

    // without lock, the two threads are not independent
    private void withoutLock() {
        new Thread(() -> {
            while (true) {
                print("abcdefg");
            }
        }).start();

        new Thread(() -> {
            while (true) {
                print("uvwxyz");
            }
        }).start();
    }

    // fail to lock because the key (lock object) is different
    private void failToLock1() {
        new Thread(() -> {
            while (true) {
                sychroizedFailPrint("abcdefg");
            }
        }).start();

        new Thread(() -> {
            while (true) {
                sychroizedFailPrint("uvwxyz");
            }
        }).start();
    }

    // lock put into wrong place
    private void failToLock2() {
        String lock = "lock";
        new Thread(() -> {
            synchronized (lock) {
                while (true) {
                    print("abcdefg");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (lock) {
                while (true) {
                    print("uvwxyz");
                }
            }
        }).start();
    }

    // successfully lock because use the same obeject
    private void lock1 () {
        new Thread(() -> {
            while (true) {
                sychroizedPrint("abcdefg");
            }
        }).start();

        new Thread(() -> {
            while (true) {
                sychroizedPrint("uvwxyz");
            }
        }).start();
    }

    void print (String s) {
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));
        }
        System.out.println();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void sychroizedFailPrint (String s) {
        synchronized (s) {
            print(s);
        }
    }

    void sychroizedPrint (String s) {
        synchronized (this) {
            print(s);
        }
    }
}
