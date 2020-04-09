package com.xc.jvm.classloader;

/**
 * 当前类加载器(Current ClassLoader)
 *
 * 每个类都会使用自己的类加载器(即加载自身的类加载器) 来加载其他类(值所依赖的类)
 * 如果classX引用了ClassY,那么ClassX的类加载器就会去加载ClassY(前提是ClassY未被加载)
 *
 * 线程上下文类加载器(Context ClassLoader)
 *
 * 如果没有通过setContextClassLoader()进行设置的话,线程将继承其父线程的上下文加载器
 * JAVA应用运行时的初始线程的上下文类加载器是系统类加载器.在线程中运行的代码可以通过该类加载器来加载类与资源
 *
 * 线程上下文类加载器的重要性:
 *
 * SPI (Service Provider Interface)
 *  父ClassLoader可以使用当前线程Thread.currentThread().getContextClassLoader()所指定的classLoader所加载的类
 *  ,这就改变父ClassLoader不能使用子ClassLoader或者其他没有直接父子关系的CLassLoader所加载的类的情况,即改变了双亲委托模型
 *
 *  在双亲委托模型下,类加载是由下至上的,即下层的类加载器会委托上层进行加载,但对于SPI来说,有些接口是java核心库所提供的.
 *  而java核心类库是由启动类加载器来加载的,二致谢接口的实现却来自与不同的jar包.java的启动类加载器是不会加载其他来源的jar包.
 *  这样传统的双亲委托模型就无法满足spi的要求.而通过给当前线程设置上下文类加载器,就可以由设置的上下文类加载器来实现
 *  对于接口实现类的加载.
 *
 *
 */
public class MyTest17 {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(Thread.class.getClassLoader());
    }
}
