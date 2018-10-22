package com.yin.design;

/**
 * 结构型模式 - 适配器模式.
 *
 * @author lijian.yin@foxmail.com
 * @date 2018/10/22
 */
public class Adapter extends A implements B {


    @Override
    public void methodA() {
        super.methodA();
    }

    @Override
    public void methodB() {
        System.out.println("methodB");
    }

    public static void main(String[] args) {
        /**
         * 类适配 - 即同时有了类A与借口B的方法
         */
        Adapter adapter = new Adapter();
        adapter.methodA();
        adapter.methodB();

        /**
         * 对象适配 - 即持有所要继承的类的实例
         */

        AdapterDto adapterDto = new AdapterDto(new A());
        adapterDto.methodA();
        adapterDto.methodB();
    }
}

class A {

    void methodA() {
        System.out.println("methodA");
    }

}

interface B {
    /**
     * 注意与A类中的methodA方法相同
     */
    void methodA();

    void methodB();
}

class AdapterDto implements B {

    A a;

    public AdapterDto(A a) {
        super();
        this.a = a;
    }

    @Override
    public void methodA() {
        a.methodA();
    }

    @Override
    public void methodB() {
        System.out.println("methodB");
    }
}
