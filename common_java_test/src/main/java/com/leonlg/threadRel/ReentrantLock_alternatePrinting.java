package com.leonlg.threadRel;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @date: 2022/9/5 22:17
 * @author: leon
 * @description 该方法存在一个问题，假设A运气比较好，一直都能抢到锁，那么num的值一直不会发生改变，其实实惠影响性能的；
 */
public class ReentrantLock_alternatePrinting {
    private int num = 0;
    private ReentrantLock lock = new ReentrantLock();

    public void printABC(int targetNum){
        for(int i = 0; i < 10; ){
            lock.lock();
            if(num % 3 == targetNum){
                System.out.println(Thread.currentThread().getName());
                i++;
                num++;
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLock_alternatePrinting reentrantLock_alternatePrinting = new ReentrantLock_alternatePrinting();
        new Thread(() -> {
            reentrantLock_alternatePrinting.printABC(0);
        }, "A").start();
        new Thread(() -> {
            reentrantLock_alternatePrinting.printABC(1);
        }, "B").start();
        new Thread(() -> {
            reentrantLock_alternatePrinting.printABC(2);
        }, "C").start();
    }
}
