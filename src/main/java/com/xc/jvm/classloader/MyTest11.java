package com.xc.jvm.classloader;

import java.net.URL;
import java.util.Enumeration;

public class MyTest11 {

    public static void main(String[] args) throws Exception{
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader);

        String resName = "com/xc/jvm/classloader/MyTest10.class";
        Enumeration<URL> resources = loader.getResources(resName);
        while (resources.hasMoreElements()){
            URL url = resources.nextElement();
            System.out.println(url);
        }

    }
}
