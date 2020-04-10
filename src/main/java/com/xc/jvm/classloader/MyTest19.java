package com.xc.jvm.classloader;


import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 线程上下文加载器的一般使用模式(获取-使用-还原)
 * <p>
 * ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
 * <p>
 * try {
 * <p>
 * Thread.currentThread().setContextClassLoader(targetClassLoader);
 * myMethod();
 * } finally {
 * Thread.currentThread().setContextClassLoader(classLoader);
 * }
 * <p>
 * myMethod()里面调用Thread.currentThread().getContextClassLoader(),获取当前线程的上下文加载器做某些事情.
 * 如果一个类由类加载器A加载,那么这个类的依赖类也是由相同的类加载器加载(如果该依赖类之前没有被加载过的话)
 * <p>
 * ContextClassLoader作用就是用来破坏java的类加载委托机制
 * <p>
 * 当高层提供统一的接口让低层实现,同时又要在高层加载(实例化)低层的类是,就必须通过线程上下文加载器来帮助高层的classLoader找到
 * 并加载该类
 */
public class MyTest19 {

    public static void main(String[] args) {
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = loader.iterator();
        while (iterator.hasNext()) {
            Driver driver = iterator.next();
            System.out.println("driver:" + driver.getClass() + ",loader:" + driver.getClass().getClassLoader());
        }

        System.out.println("contextClassLoader:" + Thread.currentThread().getContextClassLoader());

        System.out.println("ServiceLoader:" + ServiceLoader.class.getClassLoader());

    }
}
