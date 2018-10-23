package com.yin.design;

/**
 * 结构型模式 - 装饰模式
 *
 * @author lijian.yin@foxmail.com
 * @date 2018/10/23
 */
public class Decorator implements Sourceable {

    private Sourceable sourceable;

    public Decorator(Sourceable sourceable) {
        this.sourceable = sourceable;
    }

    private void before() {
        System.out.println("--------------- before ------------");
    }

    @Override
    public void say() {
        this.before();
        this.sourceable.say();
        this.after();

    }

    private void after() {
        System.out.println("--------------- after --------------");
    }

    public static void main(String[] args) {
        Sourceable sourceable = new Source();
        Decorator decorator = new Decorator(sourceable);
        decorator.say();
    }
}

interface Sourceable {
    void say();

}

class Source implements Sourceable {

    @Override
    public void say() {
        System.out.println("this is main method");
    }
}