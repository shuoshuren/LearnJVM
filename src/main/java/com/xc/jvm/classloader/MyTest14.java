package com.xc.jvm.classloader;

public class MyTest14 {

    public static void main(String[] args) throws Exception {
        MyClassLoader loader1 = new MyClassLoader("loader1");

        Class<?> clazz = loader1.loadClass("com.xc.jvm.classloader.MySample");
        System.out.println("class:"+clazz.hashCode());

        //如果注释该行,那么并不会实例化MySample对象
        Object obj = clazz.newInstance();
    }
}
