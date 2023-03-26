package org.lessons.HomeWork3.Count;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Count {
    private int count;
    private final Lock lock;

    public Count() {
        lock = new ReentrantLock();
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public void countUp() {
        if (lock.tryLock()) {
            count++;
            lock.unlock();
        }
    }
}
