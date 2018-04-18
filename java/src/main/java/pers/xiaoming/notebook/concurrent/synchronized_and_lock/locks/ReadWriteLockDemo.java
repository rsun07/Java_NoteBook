package pers.xiaoming.notebook.concurrent.synchronized_and_lock.locks;

import pers.xiaoming.notebook.concurrent.util.ThreadSleep;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class ReadWriteLockDemo {
    private ReadWriteLock rwLock = new ReentrantReadWriteLock();

    void write() {
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread() + " is accessing WRITE");
            ThreadSleep.sleep();
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    void read() {
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread() + " is accessing READ");
            ThreadSleep.sleep();
        } finally {
            rwLock.readLock().unlock();
        }
    }
}
