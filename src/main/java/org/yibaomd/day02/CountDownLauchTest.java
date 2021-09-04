package org.yibaomd.day02;

import java.util.concurrent.CountDownLatch;

public class CountDownLauchTest {

    static  CountDownLatch latch = new CountDownLatch(2);

   static class  myThread implements   Runnable{

       private String name;
       @Override
       public void run() {
           System.out.println("myThread" + name);
           latch.countDown();
       }

       public myThread(String name) {
           this.name = name;
       }
   }

    public static void main(String[] args) {


        Thread t1 = new Thread(new myThread("name1"));
        t1.start();
        Thread t2 = new Thread(new myThread("name2"));
        t2.start();
        try {
            latch.await();
            System.out.println("main 执行结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
