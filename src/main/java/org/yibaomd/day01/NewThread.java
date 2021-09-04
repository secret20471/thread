package org.yibaomd.day01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class NewThread {

    private static class  UseRun implements  Runnable{

        @Override
        public void run() {
            System.out.println("implements  Runnable");
        }
    }
    //callable 允许有返回值
    private static  class  UseCall implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println("implements  Callable");
            return "Callable";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        UseRun run = new UseRun();
        new Thread(run).start();
        Thread t1 = new Thread(run);
        t1.interrupt();
        UseCall call = new UseCall();
//        FutureTask 实现了 ruanable接口
        FutureTask<String> task = new FutureTask<>(call);
        new Thread(task).start();
        String msg = task.get();
        System.out.println(msg);

//        Thread.interrupted();
    }
}
