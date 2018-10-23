package com.yin.design;

import com.yin.design.base.Animal;
import com.yin.design.base.Dog;

/**
 * 结构型模式 - 代理模式
 *
 * @author lijian.yin@foxmail.com
 * @date 2018/10/23
 */
public class Proxy implements Animal {

    private Dog dog;

    public Proxy(Dog dog) {
        this.dog = dog;
    }

    @Override
    public void say() {
        this.dog.say();
    }

    public static void main(String[] args) {
        Proxy proxy = new Proxy(new Dog());
        proxy.say();
    }
}