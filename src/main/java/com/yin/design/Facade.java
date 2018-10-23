package com.yin.design;

/**
 * 结构型模式 - 外观模式.
 *
 * 外观模式就是将Dog、Cat放在一个Facade类中，降低了类类之间的耦合度.
 *
 * @author lijian.yin@foxmail.com
 * @date 2018/10/23
 */
public class Facade {

    private Dog dog;

    private Cat cat;

    public Facade() {
        this.dog = new Dog();
        this.cat = new Cat();
    }

    public void run () {
        this.dog.run();
        this.cat.run();
    }

    public void stop() {
        this.dog.stop();
        this.cat.stop();
    }

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.run();
        facade.stop();
    }

}

class Dog {

    void run() {
        System.out.println("Dog run ... ");
    }

    void stop() {
        System.out.println("Dog stop ...");
    }
}

class Cat {

    void run() {
        System.out.println("Cat run ... ");
    }

    void stop() {
        System.out.println("Cat stop ...");
    }
}