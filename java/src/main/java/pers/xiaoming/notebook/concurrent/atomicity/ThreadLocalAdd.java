package pers.xiaoming.notebook.concurrent.atomicity;

public class ThreadLocalAdd implements ConcurrentAdd {
    private ThreadLocal<Integer> res;

    public ThreadLocalAdd() {

        // deprecated statements
//        res = new ThreadLocal<Integer>(){
//            @Override
//            protected Integer initialValue() {
//                return 0;
//            }
//        };

        res = ThreadLocal.withInitial(() -> 0);
    }

    @Override
    public int add() {
        return add(1);
    }

    @Override
    public int add(int i) {
        res.set(res.get() + i);
        return res.get();
    }

    @Override
    public int getRes() {
        return res.get();
    }
}
