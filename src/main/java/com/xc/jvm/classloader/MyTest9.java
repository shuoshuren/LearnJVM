package com.xc.jvm.classloader;


/**
 * 调用ClassLoader类的loadClass()方法,不是对类的主动使用,不会导致类的初始化
 */
public class MyTest9 {

    public static void main(String[] args) throws Exception {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = loader.loadClass("com.xc.jvm.classloader.CL");
        System.out.println(clazz);
        System.out.println("--------");
        clazz = Class.forName("com.xc.jvm.classloader.CL");
        System.out.println(clazz);
    }
}

class CL {
    static {
        System.out.println("Class CL");
    }
}
