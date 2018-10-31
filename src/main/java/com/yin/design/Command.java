package com.yin.design;

/**
 * 行为型模式 - 命令模式
 *
 * @author lijian.yin@foxmail.com
 * @date 2018/10/31
 */
public interface Command {

    void execute();
}

class CustomCommand implements Command {

    private Receiver receiver;

    public CustomCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}

interface Receiver {

    void action();
}

class CustomReceiver implements Receiver {

    @Override
    public void action() {
        System.out.println("this is test string");
    }
}


class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action() {
        command.execute();
    }

    public static void main(String[] args) {
        Command command = new CustomCommand(new CustomReceiver());
        Invoker invoker = new Invoker(command);
        invoker.action();
    }
}

