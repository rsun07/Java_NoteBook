package pers.xiaoming.notebook.concurrent.thread;

public class NoThreadLocalDemo implements ThreadLocalDemo {
    private int res;
    private String name;

    @Override
    public int getRes() {
        return res;
    }

    @Override
    public void add() {
        res++;
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
