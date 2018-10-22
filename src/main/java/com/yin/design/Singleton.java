package com.yin.design;

/**
 * 创建型模式 - 单例模式.
 *
 * @author lijian.yin@foxmail.com
 * @date 2018/10/22
 */
public class Singleton {

    private Singleton() {
    }

    private static class SingletonFactory {
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonFactory.instance;
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
    }
}