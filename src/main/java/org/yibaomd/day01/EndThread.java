package org.yibaomd.day01;

/**
 * 如何安全的中断线程
 */
public class EndThread {

    private static class UseThread extends Thread{

        public UseThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            //如果此处为true 那么永远不会停止 根据中断标志位进行处理
            while (!isInterrupted()){
                 System.out.println(threadName + "is running");
             }
             System.out.println( threadName +" 标志位："+isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread endThread = new UseThread("endThread");
        endThread.start();
        Thread.sleep(20);
        endThread.interrupt();
    }
}
