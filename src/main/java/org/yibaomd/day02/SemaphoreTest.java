package org.yibaomd.day02;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    static Semaphore semaphore = new Semaphore(3);

    static  class  myThread extends  Thread{
        private  String name;
        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(name);
                Thread.sleep(1000);
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public myThread(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        for (int i = 0;i < 10;i++){
            Thread t = new myThread("线程name" + i);
            t.start();
        }
    }
}
