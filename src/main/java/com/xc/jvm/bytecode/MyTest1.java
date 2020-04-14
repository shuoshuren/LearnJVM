package com.xc.jvm.bytecode;


/**
 * 1.使用javap -verbose 命令分析一个字节码文件时,将会分析该字节码文件的魔数,版本号,常量池,类信息,类的构造方法
 * 类中的方法信息,类变量与成员变量等信息
 * 2.魔数:所有的.class文件的前4个字节都是魔数,固定值为:OxCAFEBABE
 *
 *
 *
 */
public class MyTest1 {

    private int a = 1;


    public int getA() {
        return this.a;
    }

    public void setA(int a) {
        this.a = a;
    }

}
