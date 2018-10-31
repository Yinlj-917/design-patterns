package com.yin.design;

/**
 * 行为型模式 - 责任链模式
 *
 * @author lijian.yin@foxmail.com
 * @date 2018/10/31
 */
public class Chain extends AnimalImpl implements IAnimal{

    private String name;

    public Chain(String name) {
        this.name = name;
    }

    @Override
    public void say() {
        System.out.println(this.name);
        if (getiAnimal() != null) {
            getiAnimal().say();
        }
    }

    public static void main (String[] args) {
        Chain chain = new Chain("flag 1");
        Chain chain1 = new Chain("flag 2");
        Chain chain3 = new Chain("flag 3");

        chain.setiAnimal(chain1);
        chain1.setiAnimal(chain3);
        chain.say();

    }
}

interface IAnimal{

    void say();
}

abstract class AnimalImpl {
    private IAnimal iAnimal;

    public IAnimal getiAnimal() {
        return iAnimal;
    }

    public void setiAnimal(IAnimal iAnimal) {
        this.iAnimal = iAnimal;
    }
}
