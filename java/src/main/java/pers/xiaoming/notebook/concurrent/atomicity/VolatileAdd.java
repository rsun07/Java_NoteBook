package pers.xiaoming.notebook.concurrent.atomicity;

public class VolatileAdd implements ConcurrentAdd {
    private volatile int res;

    @Override
    public int add() {
        return ++res;
    }

    @Override
    public int add(int i) {
        res += i;
        return res;
    }

    @Override
    public int getRes() {
        return res;
    }
}
