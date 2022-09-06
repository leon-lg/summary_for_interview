package com.leonlg.threadRel;

/**
 * @date: 2022/9/5 20:56
 * @author: leon
 */
public class AlternatePrintingOddAndEven {

    private int count;
    private Object LOCK = new Object();

    public AlternatePrintingOddAndEven(int count){
        this.count = count;
    }

    public void printOddAndEven(){
        synchronized(LOCK) {
            while(count < 10){
                System.out.print(Thread.currentThread().getName() + ":");
                System.out.println(++count);
                try {
                    LOCK.notifyAll();
                    LOCK.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            LOCK.notifyAll();
        }
    }

    public static void main(String[] args) {
        AlternatePrintingOddAndEven alternatePrintingOddAndEven = new AlternatePrintingOddAndEven(0);
        new Thread(() -> {
            alternatePrintingOddAndEven.printOddAndEven();
        }, "odd").start();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            alternatePrintingOddAndEven.printOddAndEven();
        }, "even").start();
    }
}
