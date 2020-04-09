package com.xc.jvm.classloader;


import sun.misc.Launcher;

/**
 *
 * 在运行期,一个java类是由该类的完全限定名(binary name,二进制名)和用于加载该类的定义类加载器(defining loader)所共同确定的.
 * 如果同样名字(相同的完全限定名)的类是由两个不同的加载器所加载,那么这些类就是不同的,即便.class文件的字节码完全一样,并且从相同的位置加载亦如此
 *
 * 内建于JVM的启动类加载器会加载java.lang.ClassLoader以及其他的java平台类,
 * 当jvm启动时,一块特殊的机器码会运行,会加载扩展类加载器与系统类加载器.这块特殊的机器码叫做启动类加载器(bootstrap)
 *
 * 启动类加载器并不是java类,而其他的加载类则都是java类
 * 启动类加载器是特定于平台的机器指令,负责开启整个加载过程.
 *
 * 加载第一个纯java类加载器是启动类加载器的职责.启动类加载器还会负责加载供jre正常运行所需要的基本组件,包括java.util包和java.lang中类
 *
 *
 *
 */
public class MyTest15 {

    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

        System.out.println(ClassLoader.class.getClassLoader());
        System.out.println(Launcher.class.getClassLoader());

        System.out.println("----------------");
        System.out.println(System.getProperty("java.system.class.loader"));
        System.out.println(ClassLoader.getSystemClassLoader());
    }
}
