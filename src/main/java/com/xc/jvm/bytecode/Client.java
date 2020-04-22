package com.xc.jvm.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        RealSubject rs = new RealSubject();
        InvocationHandler ds = new DynamicSubject(rs);
        Class<?> cls = rs.getClass();

        Subject proxy = (Subject)Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), ds);
        proxy.request();

        System.out.println(proxy.getClass());
        System.out.println(proxy.getClass().getSuperclass());
    }
}
