package pers.xiaoming.notebook.concurrent.thread.threadlocal;

public class NoThreadLocalDemo implements ThreadLocalDemo {
    private int i;
    private String name;

    @Override
    public int getI() {
        return i;
    }

    @Override
    public void add() {
        i++;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
