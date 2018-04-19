package pers.xiaoming.notebook.concurrent.atomicity;

class SyncAdd implements ConcurrentAdd {
    private int res;

    @Override
    public synchronized int add() {
        return ++res;
    }

    @Override
    public synchronized int add(int i) {
        res += i;
        return res;
    }

    @Override
    public int getRes() {
        return res;
    }
}
