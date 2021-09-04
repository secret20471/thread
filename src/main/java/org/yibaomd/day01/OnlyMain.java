package org.yibaomd.day01;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class OnlyMain {
    /**
     * 里面有多个线程
     * @param args arg
     */
    public static void main(String[] args){
        //虚拟机线程管理的接口-可以拿到应用程序里有多少个线程
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);
        for(ThreadInfo info: threadInfos){
            System.out.println(info.getThreadId() +" : " + info.getThreadName());
        }

    }
}
