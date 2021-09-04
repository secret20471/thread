package org.yibaomd.day01;

public class EndRunnable {

    private static class UseRunnable implements Runnable{

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            while(Thread.currentThread().isInterrupted()) {
                System.out.println(threadName+" is run!");
            }
            System.out.println(threadName+" interrput flag is " + Thread.currentThread().isInterrupted());
        }

    }

    public static void main(String[] args) throws InterruptedException {
        UseRunnable runnable = new UseRunnable();
        Thread endThread = new Thread(runnable);
        endThread.start();
        Thread.sleep(20);
        endThread.interrupt();
    }
}
