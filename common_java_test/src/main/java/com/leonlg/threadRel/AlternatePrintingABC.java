package com.leonlg.threadRel;

/**
 * @date: 2022/9/5 20:36
 * @author: leon
 */
public class AlternatePrintingABC {
    int num = 0;
    Object LOCK = new Object();

    public void printABC(int targetNum){
        for(int i = 0; i < 10; i++){
            synchronized (LOCK) {
                while(num % 3 != targetNum) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                num++;
                System.out.println(Thread.currentThread().getName());
                LOCK.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        AlternatePrintingABC alternatePrinting = new AlternatePrintingABC();
        new Thread(() -> {
            alternatePrinting.printABC(0);
        }, "A").start();
        new Thread(() -> {
            alternatePrinting.printABC(1);
        }, "B").start();
        new Thread(() -> {
            alternatePrinting.printABC(2);
        }, "C").start();
    }
}
