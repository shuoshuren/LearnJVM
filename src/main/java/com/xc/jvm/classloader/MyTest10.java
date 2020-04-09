package com.xc.jvm.classloader;

public class MyTest10 {

    public static void main(String[] args) {

        ClassLoader loader = ClassLoader.getSystemClassLoader();
        System.out.println(loader);
        while (null != loader) {
            loader = loader.getParent();
            System.out.println(loader);
        }
    }
}
