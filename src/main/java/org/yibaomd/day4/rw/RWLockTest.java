package org.yibaomd.day4.rw;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RWLockTest {

    public static CountDownLatch latch = new CountDownLatch(100);

    public static  int a = 0;

    public static  Lock lock = new ReentrantLock();

    public static void  incr(){
        try {
            lock.lock();
            a = a+1;
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Runnable able =  new IncrThread();
        for(int i = 0;i < 100;i++){
            Thread thread = new Thread(able);
            thread.start();
        }


        try {
            latch.await();
            System.out.println(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static  class IncrThread implements Runnable{

        @Override
        public void run() {
            RWLockTest.incr();
//            System.out.println(a);
            latch.countDown();
//            System.out.println(a);
        }
    }
}
