package org.yibaomd.day5.template;
/**
 * 模板方法实现
 */
public class Son extends  Father{

    @Override
    public void say() {
        System.out.println("son");
    }

    @Override
    public void hello() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        Father father = new Son();
//        father.say();
//        father.hello();
        father.tt();
    }
}
