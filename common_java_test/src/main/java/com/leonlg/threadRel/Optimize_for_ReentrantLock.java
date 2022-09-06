package com.leonlg.threadRel;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @date: 2022/9/5 22:22
 * @author: leon
 * @description 对于reentrantLock的改良版，使用Condition唤醒指定的线程，就不会导致无用的线程竞争关系了
 */
public class Optimize_for_ReentrantLock {
    private int num = 0;
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition c1 = lock.newCondition();
    private static Condition c2 = lock.newCondition();
    private static Condition c3 = lock.newCondition();

    public void printABC(int target, Condition currentCondition, Condition nextCondition){
        for(int i = 0; i < 10; i++) {
            lock.lock();
            while(num % 3 != target){
                try {
                    currentCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            num++;
            System.out.println(Thread.currentThread().getName());
            nextCondition.signal();
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Optimize_for_ReentrantLock optimize_for_reentrantLock = new Optimize_for_ReentrantLock();
        new Thread(() -> {
            optimize_for_reentrantLock.printABC(0, c1, c2);
        }, "A").start();
        new Thread(() -> {
            optimize_for_reentrantLock.printABC(1, c2, c3);
        }, "B").start();
        new Thread(() -> {
            optimize_for_reentrantLock.printABC(2, c3, c1);
        }, "C").start();
    }
}
