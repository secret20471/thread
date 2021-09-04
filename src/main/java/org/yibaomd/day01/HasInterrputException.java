package org.yibaomd.day01;

public class HasInterrputException {

    private static class UseThread extends Thread {

        public UseThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            while (!isInterrupted()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    //方法里如果抛出InterruptedException，线程的中断标志位会被复位成false，如果确实是需要中断线程，要求我们自己在catch语句块里再次调用interrupt()。
                    System.out.println(threadName+" catch interrput flag is " +isInterrupted());
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                System.out.println(threadName);
            }
            System.out.println(threadName+" run interrput flag is " +isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread endThread = new UseThread("HasInterrputEx");
        endThread.start();
        Thread.sleep(500);
        endThread.interrupt();
    }
}
