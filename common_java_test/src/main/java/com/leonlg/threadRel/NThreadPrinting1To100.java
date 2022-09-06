package com.leonlg.threadRel;

/**
 * @date: 2022/9/5 21:50
 * @author: leon
 */
public class NThreadPrinting1To100 {

    private int num = 0;
    private Object LOCK = new Object();

    public void print1To100(int targetNum){
        while(true){
            synchronized (LOCK){
                while(num % 4 != targetNum){
                    if(num > 50)break;
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if(num > 50)break;
                num++;
                System.out.println(Thread.currentThread().getName() + ":" + num);
                LOCK.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        NThreadPrinting1To100 nThreadPrinting1To100 = new NThreadPrinting1To100();
        new Thread(() -> {
            nThreadPrinting1To100.print1To100(0);
        }, "thread1").start();
        new Thread(() -> {
            nThreadPrinting1To100.print1To100(1);
        }, "thread2").start();
        new Thread(() -> {
            nThreadPrinting1To100.print1To100(2);
        }, "thread3").start();
        new Thread(() -> {
            nThreadPrinting1To100.print1To100(3);
        }, "thread4").start();
    }
}
