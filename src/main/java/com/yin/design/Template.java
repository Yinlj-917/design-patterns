package com.yin.design;

import java.util.Arrays;
import java.util.List;

/**
 * 行为性模式 - 模板模式
 *
 * @author lijian.yin@foxmail.com
 * @date 2018/10/28
 */
public abstract class Template {

    public void sum(String a, String b) {
        List<Integer> list = toInt(a, b);
        this.sum(list.get(0), list.get(1));
    }

    /**
     * 需实现的方法 以供sum(String a, String b)调用
     * @param a
     * @param b
     */
    abstract void sum(Integer a, Integer b);

    private List<Integer> toInt(String a, String b) {
        return Arrays.asList(new Integer(a), new Integer(b));
    }
}

class TemplateImpl extends Template {

    @Override
    void sum(Integer a, Integer b) {
        System.out.println(a + b);
    }

    public static void main(String[] args) {
        Template template = new TemplateImpl();
        template.sum("1", "2");
    }
}
