package ru.nsu.g.beryanov;

import java.util.concurrent.atomic.AtomicBoolean;

public class SpinLock {
    AtomicBoolean atomicReference = new AtomicBoolean();

    public void lock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + " locking...");
        while (!atomicReference.compareAndSet(false, true)) {}
    }

    public void unlock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + " unlocking...");
        atomicReference.compareAndSet(true, false);
    }

    public static void main(String[] args) throws Exception {
        SpinLock demo = new SpinLock();

        new Thread(() -> {
            demo.lock();
            try {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " starts sleeping...");
                Thread.sleep(2000);
                System.out.println(threadName + " ends sleeping...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            demo.unlock();
        }, "Thread 1").start();

        Thread.sleep(100);

        new Thread(() -> {
            demo.lock();
            demo.unlock();
        }, "Thread 2").start();
    }
}
