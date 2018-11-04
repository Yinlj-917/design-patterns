package com.yin.design;

/**
 * 行为型模式 - 访问者模式
 *
 * @author lijian.yin@foxmail.com
 * @date 2018/11/4
 */
public interface Visitor {
    void visit(Subject subject);

    static void main(String[] args) {
        Visitor visitor = new CustomVisit();
        new CustomSubject().toVisit(visitor);
    }
}

class CustomVisit implements Visitor {

    @Override
    public void visit(Subject subject) {
        System.out.println(subject.getSubject());

    }
}

interface Subject {

    void toVisit(Visitor visitor);

    String getSubject();
}

class CustomSubject implements Subject {

    @Override
    public void toVisit(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getSubject() {
        return this.getClass().getName();
    }
}