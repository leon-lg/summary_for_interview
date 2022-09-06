package com.leonlg.threadRel;

/**
 * @date: 2022/9/5 21:59
 * @author: leon
 */
public class ABC_join {
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 10; i++) {
            Thread t1 = new Thread(new PrintABC(null), "A");
            Thread t2 = new Thread(new PrintABC(t1), "B");
            Thread t3 = new Thread(new PrintABC(t2), "C");

            t1.start();
            t2.start();
            t3.start();

            //停顿10ms，让前面线程的先执行完
            Thread.sleep(10);
            System.out.println();
        }
    }
}

class PrintABC implements Runnable{

    private Thread beforeThread;

    public PrintABC(Thread beforeThread){
        this.beforeThread = beforeThread;
    }

    @Override
    public void run() {
        if(beforeThread != null){
            try {
                beforeThread.join();
                System.out.print(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            System.out.print(Thread.currentThread().getName());
        }
    }
}
