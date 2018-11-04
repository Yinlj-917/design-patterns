package com.yin.design;

import lombok.Data;

/**
 * 行为型模式 - 中介者模式
 *  相互持有引用，二者的耦合度很高
 *
 * @author lijian.yin@foxmail.com
 * @date 2018/11/4
 */
public interface Mediator {

    void createMediator();

    void getName();

    static void main(String[] args) {
        Mediator mediator = new CustomMediator();
        mediator.createMediator();
        mediator.getName();
    }
}
@Data
class CustomMediator implements Mediator {

    private Fruit apple;

    private Fruit pear;

    @Override
    public void createMediator() {
        this.apple = new Apple(this);
        this.pear = new Pear(this);
    }

    @Override
    public void getName() {
        apple.getName();
        pear.getName();
    }
}

@Data
abstract class Fruit {

    private Mediator mediator;

    public Fruit(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void getName();

}

class Apple extends Fruit {

    public Apple(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void getName() {
        System.out.println(this.getClass().getName());
    }
}

class Pear extends Fruit {

    public Pear(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void getName() {
        System.out.println(this.getClass().getName());
    }
}