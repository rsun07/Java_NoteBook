package pers.xiaoming.notebook.concurrent.atomicity;

public interface ConcurrentAdd {
    int add();

    int add(int i);

    int getRes();
}
