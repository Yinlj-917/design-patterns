package com.yin.design;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 行为型模式 - 状态模式
 *
 * @author lijian.yin@foxmail.com
 * @date 2018/10/31
 */
public interface State {
    String state();
}

class StateA implements State {

    @Override
    public String state() {
        return this.getClass().getName();
    }
}

class StateB implements State {
    @Override
    public String state() {
        return this.getClass().getName();
    }
}

@AllArgsConstructor
@Data
class Stateoperator {
    private State state;

    public void pass() {
         String before = this.state.state();
         setState(new StateB());
         String after = this.state.state();
         System.out.println(before + " -> " + after);
    }

    public static void main(String[] args) {
        Stateoperator stateoperator = new Stateoperator(new StateA());
        stateoperator.pass();
    }
}