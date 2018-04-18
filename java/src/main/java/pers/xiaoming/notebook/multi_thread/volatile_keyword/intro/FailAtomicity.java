package pers.xiaoming.notebook.multi_thread.volatile_keyword.intro;

class FailAtomicity {
    volatile int res;

    void addRes() {
        res++;
    }

    int getRes() {
        return res;
    }
}
