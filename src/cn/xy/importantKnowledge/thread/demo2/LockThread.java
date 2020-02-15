package cn.xy.importantKnowledge.thread.demo2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockThread {
    public static void main(String[] args) {
        //与 synchronized 不同的是，一旦synchronized 块结束，就会自动释放占用。 lock却必须调用unlock方法进行手动释放，为了保证释放的执行，往往会把unlock() 放在finally中进行。
        Lock lock = new ReentrantLock();
        //票数是多个线程的共享资源
        AtomicInteger ticket = new AtomicInteger(10);
        // lock中的pv操作需要这个对象
        Condition condition = lock.newCondition();
        new Thread(() -> {
            try {
                lock.lock();
//                // 申请资源，P操作，同synchronized的notify()
//                condition.signal();
                while (ticket.get() != 20) {
                    ticket.getAndIncrement();
                    System.out.println("+票，剩" + ticket + "张");
                }
//                // 释放资源，V操作，同synchronized的wait()
//                condition.await();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(2000);
                lock.tryLock(1, TimeUnit.SECONDS);
                while (ticket.get() != 0) {
                    ticket.getAndDecrement();
                    System.out.println("-票，剩" + ticket + "张");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();
        System.out.println("最终：" + ticket.get());
    }
}
