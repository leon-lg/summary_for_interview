package com.leonlg.threadRel;

import java.util.concurrent.Semaphore;

/**
 * @date: 2022/9/5 22:37
 * @author: leon
 */
public class Semaphore_AlternatePrinting {

    private int num = 0;
    private static Semaphore s1 = new Semaphore(1);
    private static Semaphore s2 = new Semaphore(0);
    private static Semaphore s3 = new Semaphore(0);

    public static void printABC(Semaphore currentS, Semaphore nextS)  {
        for(int i = 0; i < 10; i++) {
            try {
                currentS.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            nextS.release();
        }
    }

    public static void main(String[] args) {
        Semaphore_AlternatePrinting semaphore_alternatePrinting = new Semaphore_AlternatePrinting();
        new Thread(() -> {
            semaphore_alternatePrinting.printABC(s1, s2);
        }, "A").start();
        new Thread(() -> {
            semaphore_alternatePrinting.printABC(s2, s3);
        }, "B").start();
        new Thread(() -> {
            semaphore_alternatePrinting.printABC(s3, s1);
        }, "C").start();
    }
}
