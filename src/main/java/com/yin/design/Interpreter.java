package com.yin.design;

import lombok.Data;

/**
 * 行为型模式 - 解释器模式
 *
 * @author lijian.yin@foxmail.com
 * @date 2018/11/4
 */
public interface Interpreter {
    int interpret(Context context);

    static void main(String[] args) {
        // 计算9+2-8的值
        int result = new Minus().interpret(
                (
                        new Context(
                                new Plus().interpret(
                                        new Context(9, 2)
                                ),
                                8
                        )
                )
        );
        System.out.println(result);
    }

}

class Plus implements Interpreter {

    @Override
    public int interpret(Context context) {
        return context.getNum1() + context.getNum2();
    }
}

class Minus implements Interpreter {

    @Override
    public int interpret(Context context) {
        return context.getNum1() - context.getNum2();
    }
}

@Data
class Context {

    private int num1;
    private int num2;

    public Context(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
}

