package pers.xiaoming.notebook.concurrent.thread.threadlocal;

public class UseThreadLocalDemo implements ThreadLocalDemo {
    private ThreadLocal<Integer> i;
    private ThreadLocal<String> name;

    UseThreadLocalDemo() {
        i = ThreadLocal.withInitial(() -> 0);

        name = ThreadLocal.withInitial(() -> "");
    }

    @Override
    public int getI() {
        return i.get();
    }

    @Override
    public void add() {
        i.set(i.get() + 1);
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
