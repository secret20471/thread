package org.yibaomd.day02.pool;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

/**
 * 实现一个数据库的连接池
 */
public class DBPool {

    //数据库池的容器
    private  static  LinkedList<Connection> pool = new LinkedList<>() ;


    public DBPool(int initSize) {
        if (initSize > 0){
            for (int i = 0; i < initSize; i++){
                pool.add(SqlConnectImpl.fetchConnection());
            }
        }
    }
    //在mills时间内还拿不到数据库连接，返回一个null
    public Connection fetchConn(long mills) throws InterruptedException {
        synchronized (pool){
            if(mills < 0){
                while (pool.isEmpty()){
                    pool.wait();
                }
                return pool.removeFirst();
            }else {
                long overTime = System.currentTimeMillis() + mills;
                long remain = mills;
                while (pool.isEmpty()&&remain > 0){
                    pool.wait(remain);
                    remain = overTime - System.currentTimeMillis();
                }
                Connection result = null;
                if(!pool.isEmpty()){
                    result = pool.removeFirst();

                }
                return result;
            }

        }
    }

    //放回数据库连接-通知有可以用的
    public void releaseConn(Connection conn) {
        if(conn!=null) {
            synchronized (pool) {
                pool.addLast(conn);
                pool.notifyAll();
            }
        }
    }

}
