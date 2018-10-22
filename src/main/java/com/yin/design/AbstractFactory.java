package com.yin.design;

import com.yin.design.base.Animal;
import com.yin.design.base.Cat;
import com.yin.design.base.Dog;
import org.apache.commons.lang3.StringUtils;

/**
 * 创建型模式 - 抽象工厂模式.
 *
 * @author lijian.yin@foxmail.com
 * @date 2018/10/22
 */
public class AbstractFactory {

    public static void main(String[] args) {

       Animal animal = AFactroy.getInstance(Animal.DOG);
       if (null != animal) {
           animal.say();
       }
    }

}

interface Product {
    Animal get();
}

class FactoryA implements Product {

    public Animal get() {
        return new Dog();
    }
}

class FactoryB implements Product {

    public Animal get() {
        return new Cat();
    }
}

class AFactroy {

    public static Animal getInstance(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        if (StringUtils.equalsIgnoreCase(name, Animal.DOG)) {
            return new FactoryA().get();
        }
        if (StringUtils.equalsIgnoreCase(name, Animal.CAT)) {
            return new FactoryB().get();
        }
        return null;
    }

}
