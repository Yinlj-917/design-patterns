package com.yin.design;

/**
 * 结构型模式 - 代理模式
 *
 * @author lijian.yin@foxmail.com
 * @date 2018/10/23
 */
public class Proxy implements Sourceable {

    private Source source;

    public Proxy(Source source) {
        this.source = source;
    }

    @Override
    public void say() {
        this.source.say();
    }

    public static void main(String[] args) {
        Proxy proxy = new Proxy(new Source());
        proxy.say();
    }
}

interface Sourceable {
    void say();
}

class Source implements Sourceable {
    @Override
    public void say() {
        System.out.println("---------- say ---------");
    }
}

