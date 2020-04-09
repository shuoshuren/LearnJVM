package com.xc.jvm.classloader;

/**
 * 数组的classLoader和它的元素的ClassLoader一样,
 * 原始数据的数组没有classLoader
 *
 *
 */
public class MyTest12 {

    public static void main(String[] args) {
        String[] strs = new String[1];
        System.out.println(strs.getClass().getClassLoader());

        MyTest12[] myTest12s = new MyTest12[1];
        System.out.println(myTest12s.getClass().getClassLoader());

        int[] ints = new int[1];
        System.out.println(ints.getClass().getClassLoader());
    }
}
