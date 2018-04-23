package pers.xiaoming.notebook.concurrent.thread.threadlocal;

public class UseThreadLocalDemo implements ThreadLocalDemo {
    private ThreadLocal<Integer> res;
    private ThreadLocal<String> name;

    UseThreadLocalDemo() {
        res = ThreadLocal.withInitial(() -> 0);

        name = ThreadLocal.withInitial(() -> "");
    }

    @Override
    public int getRes() {
        return res.get();
    }

    @Override
    public void add() {
        res.set(res.get() + 1);
    }

    @Override
    public String getName() {
        return name.get();
    }

    @Override
    public void setName(String name) {
        this.name.set(name);
    }
}
