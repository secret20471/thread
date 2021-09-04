package org.yibaomd.day5.template;

/**
 * 模板方法
 */
public abstract class Father {

    public  void say(){
        System.out.println("father");
    }

    public abstract void hello();

    /**
     * 框架方法-模板方法
     */
    public void tt(){
        say();
        hello();
    }
}
