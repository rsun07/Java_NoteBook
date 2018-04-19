package pers.xiaoming.notebook.concurrent.atomicity;

public class NonAtomicAdd implements ConcurrentAdd {
    private int res;

    @Override
    public int add() {
        return add(1);
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
