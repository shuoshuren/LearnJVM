package com.xc.jvm.classloader;

import java.lang.reflect.Method;


/**
 * 类双亲委派加载的好处:
 * 1.可以确保Java核心库的类型安装:所有的java应用都至少会引用java.lang.Object类,
 * 这个类会被加载到jvm中,如果加载过程是由java应用自己加载的完成的,那么可能存在多个版本Object类,而且
 * 这些类之间是不兼容,相互之间不可见.借助双亲委托机制,Java核心库的类的加载工作都是由启动类加载器来统一完成,
 * 从而确保了Java应用所使用的都是同一个版本的java核心库,他们之间是相互兼容的
 * 2.可以确保java核心类库所提供的类不会被自定义的类所替代
 * 3.不同的类加载器可以为相同名称(binary name)的类创建额外的命名空间,相同名称的类可以并存在JVM中,只需要用不同的类加载器来加载他们即可.
 * 不同类加载器所加载的类之间是不兼容的,相当于在java虚拟机内部创建一个又一个相互隔离的java类空间.这类技术在很多框架中得到了实际应用
 *
 *
 */
public class MyTest16 {

    private static final String CLASS_PATH = "com.xc.jvm.classloader.MyPerson";

    public static void main(String[] args) throws Exception{


        MyClassLoader loader1 = new MyClassLoader("loader1");
        MyClassLoader loader2 = new MyClassLoader("loader2");

        loader1.setPath(MyClassLoader.DESKTOP_PATH);
        loader2.setPath(MyClassLoader.DESKTOP_PATH);

        Class<?> clazz1 = loader1.loadClass(CLASS_PATH);
        Class<?> clazz2 = loader2.loadClass(CLASS_PATH);

        System.out.println(clazz1 == clazz2);

        Object obj1 = clazz1.newInstance();
        Object obj2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setPerson", MyPerson.class);
        method.invoke(obj1,obj2);
    }
}
