package com.xc.jvm.classloader;

public class MyTest7 {

    public static void main(String[] args) throws Exception{
        Class<?> clazz = Class.forName("java.lang.String");
        ClassLoader classLoader = clazz.getClassLoader();
        System.out.println("classLoader:"+classLoader);

        Class<?> clazz2 = Class.forName("com.xc.jvm.classloader.C");
        System.out.println(clazz2.getClassLoader());
    }
}


class C {

}