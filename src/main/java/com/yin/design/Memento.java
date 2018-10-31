package com.yin.design;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 行为型模式 - 备忘录模式
 *
 * @author lijian.yin@foxmail.com
 * @date 2018/10/31
 */
@Data
@AllArgsConstructor
public class Memento {
    private String value;

    public static void main(String[] args) {
        Original original = new Original("A");
        // 重新new了一个Memento
        Storage storage = new Storage(original.createMemento());

        original.setValue("B");
        System.out.println(original.getValue());

        original.restoreMemento(storage.getMemento());
        System.out.println(original.getValue());
    }
}

@AllArgsConstructor
@Data
class Original {
    private String value;

    public Memento createMemento() {
        return new Memento(this.value);
    }
    public void restoreMemento(Memento memento){
        this.value = memento.getValue();
    }
}

@Data
@AllArgsConstructor
class Storage{
    private Memento memento;
}