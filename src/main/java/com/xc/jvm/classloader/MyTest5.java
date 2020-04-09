package com.xc.jvm.classloader;


/**
 * 当一个接口在初始化时,并不要求其父接口都完成了初始化
 * 只有在真正上使用父接口的时候(如引用接口中所定义的常量时),才会进行初始化
 */
public class MyTest5 {

    public static void main(String[] args) {
        System.out.println(MyChild5.b);
    }
}


interface MyParent5 {


    public static Thread thread = new Thread() {

        {
            System.out.println("MyParent5 invoke");

        }
    };
}

class MyChild5 implements MyParent5 {

    public static int b = 3;
}
