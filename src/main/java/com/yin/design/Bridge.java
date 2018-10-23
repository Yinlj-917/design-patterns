package com.yin.design;

import com.yin.design.base.Animal;
import com.yin.design.base.Cat;
import com.yin.design.base.Dog;

/**
 * 结构型模式 -  桥接模式
 *
 * 将抽象化与实现化解耦，使得二者可以独立变化
 *
 * @author lijian.yin@foxmail.com
 * @date 2018/10/23
 */
public class Bridge extends PBridge{

    @Override
    public void say() {
        getAnimal().say();
    }

    public static void main(String[] args) {
        PBridge bridge = new Bridge();

        bridge.setAnimal(new Dog());
        bridge.say();

        bridge.setAnimal(new Cat());
        bridge.say();
    }
}

class PBridge {
    private Animal animal;

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void say() {
        animal.say();
    }
}