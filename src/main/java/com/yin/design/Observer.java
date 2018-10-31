package com.yin.design;

import java.util.ArrayList;
import java.util.List;

/**
 * 行为型模式 - 观察者模式
 *
 * @author lijian.yin@foxmail.com
 * @date 2018/10/31
 */
public class Observer extends ObserverImpl {


    @Override
    public void selfOperate() {
        super.update();
    }

    public static void main(String[] args) {
        IObserver observer = new Observer();
        observer.add(new Sound_A());
        observer.add(new Sound_B());
        observer.selfOperate();
    }
}


interface Sound{

    void say();
}

class Sound_A implements Sound {

    @Override
    public void say() {
        System.out.println(this.getClass().getName() + " - say");
    }
}

class Sound_B implements Sound {

    @Override
    public void say() {
        System.out.println(this.getClass().getName() + " - say");
    }
}

interface IObserver {

    void add(Sound sound);

    void update();

    void delete(Sound sound);

    void selfOperate();
}

abstract class ObserverImpl implements IObserver {

    private List<Sound> sounds = new ArrayList<>();

    @Override
    public void add(Sound sound) {
        sounds.add(sound);
    }

    @Override
    public void update() {
        this.sounds.stream().forEach(Sound::say);
    }

    @Override
    public void delete(Sound sound) {
        this.sounds.remove(sound);
    }
}