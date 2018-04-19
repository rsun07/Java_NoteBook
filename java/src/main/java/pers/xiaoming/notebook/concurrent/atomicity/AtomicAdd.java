package pers.xiaoming.notebook.concurrent.atomicity;

import java.util.concurrent.atomic.AtomicInteger;

class AtomicAdd implements ConcurrentAdd {
    private AtomicInteger res;

    public AtomicAdd() {
        this.res = new AtomicInteger();
    }

    @Override
    public int add() {
        return add(1);

    }

    @Override
    public int add(int i) {
        return res.addAndGet(i);

    }

    @Override
    public int getRes() {
        return res.get();
    }
}
