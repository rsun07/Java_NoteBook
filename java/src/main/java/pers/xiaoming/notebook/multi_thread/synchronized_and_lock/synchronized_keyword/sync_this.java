package pers.xiaoming.notebook.multi_thread.synchronized_and_lock.synchronized_keyword;

class sync_this {
    void print1() {
        synchronized (this) {
            System.out.println("print1");

        }
    }


}
