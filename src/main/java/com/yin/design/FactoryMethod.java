package com.yin.design;

import com.yin.design.base.Animal;
import com.yin.design.base.Cat;
import com.yin.design.base.Dog;
import org.apache.commons.lang3.StringUtils;

/**
 * 创建型模式 - 工厂模式.
 *
 * @author lijian.yin@foxmail.com
 * @date 2018/10/22
 */
public class FactoryMethod {

    public static void main(String[] args) {
        Animal animal = Factory.getInstance(Animal.CAT);
        if (animal != null) {
            animal.say();
        }
    }
}

class Factory {

    static Animal getInstance(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        if (StringUtils.equalsIgnoreCase(name, Animal.DOG)) {
            return new Dog();
        }
        if (StringUtils.equalsIgnoreCase(name, Animal.CAT)) {
            return new Cat();
        }
        return null;
    }
}


