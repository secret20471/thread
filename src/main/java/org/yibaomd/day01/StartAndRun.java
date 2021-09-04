package org.yibaomd.day01;



/**
 *@author Mark老师   享学课堂 https://enjoy.ke.qq.com 
 *
 *类说明：start和run方法的区别
 */
public class StartAndRun {
    public static class ThreadRun extends Thread{

        @Override
        public void run() {
            int i = 90;
            while(i>0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("I am "+Thread.currentThread().getName()
                		+" and now the i="+i--);
            }
        }
    }
    
    private static class User {
    	public void us() {
    		
    	}
    }

    public static void main(String[] args) {
    	ThreadRun beCalled = new ThreadRun();
    	beCalled.setName("BeCalled");
    	//beCalled.setPriority(newPriority);
    	beCalled.run();
    	beCalled.setPriority(5);
        beCalled.start();
    	User user = new User();
    	user.us();
    	
    	//beCalled.start();
    }
}
