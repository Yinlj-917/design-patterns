package com.yin.design;

import java.io.*;

/**
 * 创建型模式 - 原型模式
 *
 *  将一个对象作为原型，对其进行复制、克隆，产生一个和原对象类似的新对象。
 *
 *  其实就是通过序列化进行深复制（彻底复制）
 *
 * @author lijian.yin@foxmail.com
 * @date 2018/10/22
 */
public class Prototype implements Cloneable, Serializable {


    private static final long serialVersionUID = 1L;
    private String string;


    private SerializableObject obj;

    @Override
    public Object clone() throws CloneNotSupportedException {
        Prototype proto = (Prototype) super.clone();
        return proto;
    }

    public Object deepClone() throws IOException, ClassNotFoundException {


        /* 写入当前对象的二进制流 */
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);


        /* 读出二进制流产生的新对象 */
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }


    public String getString() {
        return string;
    }


    public void setString(String string) {
        this.string = string;
    }


    public SerializableObject getObj() {
        return obj;
    }


    public void setObj(SerializableObject obj) {
        this.obj = obj;
    }


}


class SerializableObject implements Serializable {
    private static final long serialVersionUID = 1L;
}
