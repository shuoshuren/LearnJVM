package com.xc.jvm.classloader;

public class MyTest13 {


    public static void test(ClassLoader loader) throws Exception {
        Class<?> clazz = loader.loadClass("com.xc.jvm.classloader.MyTest1");
        Object obj = clazz.newInstance();
        System.out.println("class:" + clazz.hashCode());
        System.out.println(obj);
        System.out.println("loader:" + obj.getClass().getClassLoader());
    }


    public static void main(String[] args) throws Exception {

        MyClassLoader loader1 = new MyClassLoader("loader1");
        loader1.setPath(MyClassLoader.DESKTOP_PATH);
        test(loader1);
        System.out.println("-----------------");
        MyClassLoader loader2 = new MyClassLoader(loader1, "loader2");
        loader2.setPath(MyClassLoader.DESKTOP_PATH);
        test(loader2);

        System.out.println("-----------------");
        MyClassLoader loader3 = new MyClassLoader(loader2, "loader3");
        loader3.setPath(MyClassLoader.DESKTOP_PATH);
        test(loader3);


    }
}
